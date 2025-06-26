package com.mutlukodcu.kkka.shared.kafka.events;

import lombok.Data;

@Data
public class GeneSequenceEvent {
    private String geneId;
    private String sequence;
    private String userId;
}
