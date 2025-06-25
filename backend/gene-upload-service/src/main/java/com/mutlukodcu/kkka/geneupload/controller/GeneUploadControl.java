package com.mutlukodcu.kkka.geneupload.controller;

import com.mutlukodcu.kkka.geneupload.dto.GeneUploadResponseDTO;
import com.mutlukodcu.kkka.geneupload.service.GeneUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/gene-upload")
public class GeneUploadController {

    @Autowired
    private GeneUploadService geneUploadService;

    @PostMapping("/upload")
    public ResponseEntity<GeneUploadResponseDTO> uploadGeneFile(@RequestParam("file") MultipartFile file) {
        GeneUploadResponseDTO response = geneUploadService.processUpload(file);
        return ResponseEntity.ok(response);
    }
}
