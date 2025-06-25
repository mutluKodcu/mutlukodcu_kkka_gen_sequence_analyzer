package com.mutlukodcu.kkka.geneupload.service;

import com.mutlukodcu.kkka.geneupload.dto.GeneUploadResponseDTO;
import com.mutlukodcu.kkka.geneupload.model.GeneSequence;
import com.mutlukodcu.kkka.geneupload.repository.GeneSequenceRepository;
import com.mutlukodcu.kkka.geneupload.util.FileParserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class GeneUploadService {

    @Autowired
    private GeneSequenceRepository geneSequenceRepository;

    public GeneUploadResponseDTO processUpload(MultipartFile file) {
        // Dosyayı okuyup gen sekanslarını ayrıştır
        List<GeneSequence> sequences = FileParserUtil.parseFile(file);

        // Veritabanına kaydet
        geneSequenceRepository.saveAll(sequences);

        // Dönüş cevabı hazırla
        GeneUploadResponseDTO response = new GeneUploadResponseDTO();
        response.setMessage("Dosya başarıyla yüklendi ve " + sequences.size() + " sekans kaydedildi.");
        response.setRecordCount(sequences.size());

        return response;
    }
}
