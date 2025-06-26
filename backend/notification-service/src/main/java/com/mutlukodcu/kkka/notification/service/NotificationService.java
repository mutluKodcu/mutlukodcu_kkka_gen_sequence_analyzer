package com.mutlukodcu.kkka.notification.service;

import com.mutlukodcu.kkka.shared.dto.AnalysisResultDTO;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public void sendNotification(AnalysisResultDTO result) {
        // Burada email/sms/log gibi bildirim sistemine entegrasyon yapılabilir
        System.out.println("Bildirim gönderildi: " + result.getUserEmail() + " - " + result.getResultSummary());
    }
}
