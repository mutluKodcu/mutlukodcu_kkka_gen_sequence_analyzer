package com.mutlukodcu.kkka.genanalysis.util;

import org.springframework.stereotype.Component;

@Component
public class BayesAnalyzer {

    public double calculateRisk(String geneSequence) {
        long countA = geneSequence.chars().filter(ch -> ch == 'A').count();
        return (double) countA / geneSequence.length();
    }
}
