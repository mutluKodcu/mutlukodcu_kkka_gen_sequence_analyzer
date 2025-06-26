# 🔔 Notification Service

Bu servis, KKKA genetik analiz sonuçlarının kullanıcılara bildirilmesini sağlar. Kafka üzerinden gelen `AnalysisResultDTO` mesajlarını dinler ve ilgili kullanıcıya bildirim gönderir.

## 🚀 Özellikler

- Kafka üzerinden analiz sonuçlarını dinler (`analysis-result-topic`)
- E-posta/sms/log tabanlı bildirim senaryolarına entegre edilebilir
- `shared-lib` içerisindeki DTO yapısını kullanır

## 🛠️ Çalıştırma

```bash
mvn clean package
docker build -t notification-service .
docker run -p 8087:8087 notification-service
```

## 📁 Paket Yapısı

- `listener/` → Kafka consumer
- `service/` → Bildirim iş mantığı
- `resources/application.yml` → Spring ve Kafka konfigürasyonu

