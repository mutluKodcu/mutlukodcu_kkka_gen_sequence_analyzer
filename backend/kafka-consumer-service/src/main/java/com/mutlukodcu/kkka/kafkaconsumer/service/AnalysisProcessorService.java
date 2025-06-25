package com.mutlukodcu.kkka.kafkaconsumer.service;

import com.mutlukodcu.kkka.kafkaconsumer.model.GeneSequencePayload;

import org.springframework.stereotype.Service;

@Service
public class AnalysisProcessorService {

    // Örnek: Analiz servisine çağrı, veriyi işle, Kafka'ya mesaj gönder vs.
    public void processGeneSequence(GeneSequencePayload payload) {
        // İş mantığı burada olacak
        System.out.println("Gen sekansı işleniyor: " + payload.getGeneSequence());
        // TODO: Analiz servisine veri gönderme işlemi
    }
}
