package com.mutlukodcu.kkka.report.util;

import com.mutlukodcu.kkka.report.dto.ReportRequestDTO;

public class ExcelExporter {

    public static String exportToExcel(ReportRequestDTO request) {
        // Burada Excel dosyası oluşturulabilir.
        return "mocked-path/report-" + request.getUserId() + ".xlsx";
    }
}
