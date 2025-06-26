package com.mutlukodcu.kkka.report.controller;

import com.mutlukodcu.kkka.report.dto.ReportRequestDTO;
import com.mutlukodcu.kkka.report.service.ReportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @PostMapping
    public ResponseEntity<String> generateReport(@RequestBody ReportRequestDTO request) {
        String fileUrl = reportService.generateReport(request);
        return ResponseEntity.ok(fileUrl);
    }
}
