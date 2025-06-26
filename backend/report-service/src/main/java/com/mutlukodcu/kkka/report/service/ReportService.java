package com.mutlukodcu.kkka.report.service;

import com.mutlukodcu.kkka.report.dto.ReportRequestDTO;
import com.mutlukodcu.kkka.report.util.ExcelExporter;
import org.springframework.stereotype.Service;

@Service
public class ReportService {

    public String generateReport(ReportRequestDTO request) {
        return ExcelExporter.exportToExcel(request);
    }
}
