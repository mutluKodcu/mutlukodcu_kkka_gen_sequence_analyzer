# 📦 shared-lib

Bu modül, KKKA Genetik Analiz Platformu için mikroservisler arasında paylaşılan **ortak sınıfları ve sabitleri** içerir.

---

## 🧩 İçerik

### 1. DTO (Data Transfer Objects)
- `UserDTO` – Kullanıcı bilgileri
- `GeneSequenceDTO` – Gen sekansı yükleme ve taşıma
- `AnalysisResultDTO` – Analiz sonucu bildirimleri (🔔 `notification-service` tarafından kullanılır)

### 2. Kafka Event Modelleri
- `GeneSequenceEvent` – Kafka üzerinden servisler arası gen sekans veri alışverişi

### 3. Constants
- `AppConstants` – Ortak sabitler (örneğin: Kafka topic adları)

### 4. Utility Class
- `DateUtils` – Tarih/saat formatlama gibi yardımcı metotlar

---

## Kullanım

Diğer mikroservislerde `pom.xml` içine eklenmelidir:

```xml
<dependency>
  <groupId>com.mutlukodcu.kkka</groupId>
  <artifactId>shared-lib</artifactId>
  <version>0.0.1-SNAPSHOT</version>
</dependency> ```

## Derleme 
cd backend/shared-lib
mvn clean install

## Dizin
```
src/main/java/com/mutlukodcu/kkka/shared/
├── dto/
├── kafka/events/
├── constants/
└── utils/ ```