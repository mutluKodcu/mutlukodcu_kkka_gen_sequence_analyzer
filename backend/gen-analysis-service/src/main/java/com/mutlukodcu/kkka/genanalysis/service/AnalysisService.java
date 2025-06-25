package com.mutlukodcu.kkka.genanalysis.service;

import com.mutlukodcu.kkka.genanalysis.dto.AnalysisRequestDTO;
import com.mutlukodcu.kkka.genanalysis.model.AnalysisResult;
import com.mutlukodcu.kkka.genanalysis.repository.AnalysisResultRepository;
import com.mutlukodcu.kkka.genanalysis.util.BayesAnalyzer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AnalysisService {

    @Autowired
    private AnalysisResultRepository repository;

    @Autowired
    private BayesAnalyzer bayesAnalyzer;

    public AnalysisResult analyzeGeneSequence(AnalysisRequestDTO dto) {
        double riskScore = bayesAnalyzer.calculateRisk(dto.getGeneSequence());
        String riskCategory = categorizeRisk(riskScore);

        AnalysisResult result = new AnalysisResult();
        result.setGeneSequence(dto.getGeneSequence());
        result.setRiskScore(riskScore);
        result.setRiskCategory(riskCategory);
        result.setAnalyzedAt(LocalDateTime.now());

        return repository.save(result);
    }

    private String categorizeRisk(double score) {
        if(score > 0.7) return "High Risk";
        if(score > 0.4) return "Medium Risk";
        return "Low Risk";
    }
}
