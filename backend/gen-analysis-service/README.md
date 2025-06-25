# Gen Analysis Service

## Proje Hakkında
Gen Analysis Service, Kırım Kongo Kanamalı Ateşi (KKKA) hastalığına sebep olan genetik risk faktörlerini Bayes modeli kullanarak analiz eden bir mikroservistir. Gelen gen sekanslarını alır, Bayes analizi yapar ve sonuçları PostgreSQL veritabanında kalıcı olarak saklar. Ayrıca Kafka aracılığıyla asenkron mesajlaşma desteği sağlar.

## Proje Yapısı

src/main/java/com/mutlukodcu/kkka/genanalysis/
 ├── config/               # Kafka ve diğer konfigürasyonlar
 ├── controller/           # REST API controller
 ├── dto/                  # Veri transfer objeleri
 ├── service/              # İş mantığı katmanı
 ├── repository/           # JPA veri erişim katmanı
 ├── util/                 # Bayes analiz algoritması
 ├── exception/            # Özel hata sınıfları
 └── GenAnalysisServiceApplication.java
 
## Özellikler
- REST API üzerinden gen sekansı alma ve analiz etme
- Bayes modeli tabanlı genetik risk analizi
- Sonuçların PostgreSQL veritabanına kaydedilmesi
- Kafka ile entegrasyon ve mesaj alışverişi
- Spring Boot ile geliştirilmiş modüler yapı
- Docker ile konteynerizasyon desteği

## Gereksinimler
- Java 17
- Maven 3.6+
- PostgreSQL 12+
- Kafka (opsiyonel, yapılandırmaya bağlı)
- Docker (opsiyonel, konteyner için)

## Kurulum ve Çalıştırma

### Maven ile
```bash
mvn clean package
mvn spring-boot:run ```

## Docker ile
	docker build -t gen-analysis-service .
	docker run -p 8084:8084 gen-analysis-service
Kafka Kullanımı
Kafka konfigürasyonu application.yml dosyasından yönetilir. Servis, gen sekansı analizlerini Kafka topic'lerine mesaj olarak gönderir.

## API Kullanımı
POST /api/analysis/analyze
	Gen sekansı analiz etme endpoint’i.

Req (JSON):
{
  "geneSequence": "ATCGATCGAGCT..."
}

Res:
{
  "id": 123,
  "riskScore": 0.87,
  "result": "High Risk",
  "timestamp": "2025-06-25T12:34:56"
}

## Lisans :
Bu proje MIT Lisansı ile lisanslanmıştır.

