package com.mutlukodcu.kkka.kafkaconsumer.model;

import com.fasterxml.jackson.databind.ObjectMapper;

public class GeneSequencePayload {

    private String geneSequence;
    private String sampleId;

    // Getter ve Setterlar
    public String getGeneSequence() {
        return geneSequence;
    }

    public void setGeneSequence(String geneSequence) {
        this.geneSequence = geneSequence;
    }

    public String getSampleId() {
        return sampleId;
    }

    public void setSampleId(String sampleId) {
        this.sampleId = sampleId;
    }

    // JSON’dan nesneye dönüştürme
    public static GeneSequencePayload fromJson(String json) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(json, GeneSequencePayload.class);
        } catch (Exception e) {
            throw new RuntimeException("JSON parse hatası", e);
        }
    }
}
