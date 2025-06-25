package com.mutlukodcu.kkka.genanalysis.controller;

import com.mutlukodcu.kkka.genanalysis.dto.AnalysisRequestDTO;
import com.mutlukodcu.kkka.genanalysis.model.AnalysisResult;
import com.mutlukodcu.kkka.genanalysis.service.AnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/analysis")
public class AnalysisController {

    @Autowired
    private AnalysisService analysisService;

    @PostMapping("/analyze")
    public ResponseEntity<AnalysisResult> analyze(@RequestBody AnalysisRequestDTO requestDTO) {
        AnalysisResult result = analysisService.analyzeGeneSequence(requestDTO);
        return ResponseEntity.ok(result);
    }
}
