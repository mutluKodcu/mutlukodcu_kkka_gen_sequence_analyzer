package com.mutlukodcu.kkka.notification.kafka.listener;

import com.mutlukodcu.kkka.shared.dto.AnalysisResultDTO;
import com.mutlukodcu.kkka.notification.service.NotificationService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class AnalysisResultListener {

    private final NotificationService notificationService;

    public AnalysisResultListener(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @KafkaListener(topics = "analysis-result-topic", groupId = "notification-group")
    public void listen(AnalysisResultDTO result) {
        notificationService.sendNotification(result);
    }
}
