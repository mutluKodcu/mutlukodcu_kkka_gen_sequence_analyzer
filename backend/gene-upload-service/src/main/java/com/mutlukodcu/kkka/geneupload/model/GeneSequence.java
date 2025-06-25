package com.mutlukodcu.kkka.geneupload.model;

import jakarta.persistence.*;

@Entity
@Table(name = "gene_sequences")
public class GeneSequence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sequence_data", nullable = false, length = 2000)
    private String sequenceData;

    @Column(name = "source_file")
    private String sourceFile;

    // Getter ve Setter metodları

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSequenceData() {
        return sequenceData;
    }

    public void setSequenceData(String sequenceData) {
        this.sequenceData = sequenceData;
    }

    public String getSourceFile() {
        return sourceFile;
    }

    public void setSourceFile(String sourceFile) {
        this.sourceFile = sourceFile;
    }
}
