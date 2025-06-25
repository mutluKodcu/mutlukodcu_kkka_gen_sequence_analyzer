package com.mutlukodcu.kkka.genanalysis.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "analysis_results")
public class AnalysisResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String geneSequence;

    private Double riskScore;

    private String riskCategory;

    private LocalDateTime analyzedAt;

    // getters ve setters
    // ...
}
