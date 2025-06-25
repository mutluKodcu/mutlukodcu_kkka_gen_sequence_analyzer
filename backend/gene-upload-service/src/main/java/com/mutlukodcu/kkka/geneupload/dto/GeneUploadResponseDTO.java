package com.mutlukodcu.kkka.geneupload.dto;

public class GeneUploadResponseDTO {

    private String message;
    private int recordCount;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }
}
