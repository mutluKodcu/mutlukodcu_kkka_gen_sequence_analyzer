package com.mutlukodcu.kkka.genanalysis.repository;

import com.mutlukodcu.kkka.genanalysis.model.AnalysisResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnalysisResultRepository extends JpaRepository<AnalysisResult, Long> {
}
