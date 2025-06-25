package com.mutlukodcu.kkka.geneupload.util;

import com.mutlukodcu.kkka.geneupload.model.GeneSequence;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileParserUtil {

    public static List<GeneSequence> parseFile(MultipartFile file) {
        List<GeneSequence> sequences = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Örnek olarak FASTA dosyasındaki gen sekanslarını basitçe alıyoruz
                if (!line.startsWith(">") && !line.trim().isEmpty()) {
                    GeneSequence seq = new GeneSequence();
                    seq.setSequenceData(line.trim());
                    seq.setSourceFile(file.getOriginalFilename());
                    sequences.add(seq);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Dosya okuma/parsing hatası: " + e.getMessage());
        }

        return sequences;
    }
}
