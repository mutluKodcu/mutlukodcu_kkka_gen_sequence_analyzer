package com.mutlukodcu.kkka.kafkaconsumer.consumer;

import com.mutlukodcu.kkka.kafkaconsumer.model.GeneSequencePayload;
import com.mutlukodcu.kkka.kafkaconsumer.service.AnalysisProcessorService;
import com.mutlukodcu.kkka.kafkaconsumer.util.LoggingUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class GeneSequenceKafkaListener {

    @Autowired
    private AnalysisProcessorService analysisProcessorService;

    @KafkaListener(topics = "kkka.gene.sequences", groupId = "kkka-group")
    public void listen(String message) {
        LoggingUtils.logInfo("Kafka mesajı alındı: " + message);
        // Basit JSON parse edilebilir, burada örnek
        GeneSequencePayload payload = GeneSequencePayload.fromJson(message);
        analysisProcessorService.processGeneSequence(payload);
    }
}
