# Mutlukodcu KKKA Gen Sequence Analyzer

Bu proje, **Kırım Kongo Kanamalı Ateşi (KKKA)** hastalığına sebep olabilecek genetik varyasyonların analizini yapmak ve risk değerlendirmesi sağlamak için geliştirilmiş bir **biyoinformatik analiz platformudur**.

## 🔬 Projenin Amacı ve Kapsamı

Bu yazılım, araştırmacıların gen sekanslarını sisteme yükleyerek potansiyel olarak hastalık riski taşıyan varyasyonları analiz etmelerini sağlar.
Ayrıca bu veriler üzerinden genetik ve coğrafi analizlerle haritalama ve istatistiksel değerlendirme yapılmasına olanak tanır.

## ⚙️ Kullanılan Teknolojiler

- **Backend**: Java 17, Spring Boot, Spring Security, JWT, Kafka, Hibernate, PostgreSQL, Apache POI
- **Frontend**: ReactJS, Bootstrap 5
- **Veritabanı**: PostgreSQL
- **Mesajlaşma**: Kafka, Zookeeper
- **Orkestrasyon**: Docker, Docker Compose
- **Dokümantasyon**: Swagger UI

## 🧬 Senaryo:
- Kullanıcı, genetik test sonuçlarını yükler (örneğin FASTA formatlı veya JSON/Excel). 
- Sistem: Gen sekanslarını analiz eder
- Belirli gen motifleri üzerinden hastalık riskini Bayes modelleriyle hesaplar.
- Sonuçları kaydeder ve gösterir.
- Kafka ile analiz işlemlerini mikroservislere dağıtır.
- Karar destek (risk derecesi, önerilen adımlar) sağlar.

## 📁 Proje Dizin Yapısı
```
mutlukodcu_kkka_gen_sequence_analyzer/
├── backend/
│   ├── auth-service/             → Giriş, rol yönetimi (Spring Security + JWT)
│   ├── gene-upload-service/      → Excel/JSON/FASTA dosya yükleme (Apache POI)
│   ├── analysis-service/         → Bayes Modeli ile gen analiz + PostgreSQL
│   ├── report-service/           → Excel çıktısı + analiz sonucu
│   ├── kafka-consumer-service/   → Asenkron analizler için Kafka tüketicisi
│   ├── api-gateway/              → Tüm microservis isteklerinin önündeki Gateway. JWT doğrulama, rota yönetimi, Swagger entegrasyonu
│   ├── shared-lib/               → Ortak DTO, sabitler ve Kafka event modelleri yer alır
│   ├── discovery-service/        → Servislerin otomatik keşfi için Eureka veya benzeri servis keşif aracı
│   ├── notification-service/     → Analiz sonuçlarının kullanıcıya bildirilmesi için bildirim servisi
│
├── frontend/                     → ReactJS + Bootstrap 5 tabanlı kullanıcı arayüzü
│
├── docs/                        → Proje mimari diyagramları, UML, ER ve Sequence diagramları
│
├── docker-compose.yml           → Tüm servislerin Docker konteyner tanımları
├── init.sql                     → PostgreSQL için başlangıç tabloları ve demo veriler
├── Makefile                    → Kolay build ve docker-compose komutları için otomasyon
├── README.md                   → Proje hakkında genel bilgi ve kullanım dokümantasyonu
└── LICENSE                     → Lisans bilgisi
```

```
mutlukodcu_kkka_gen_sequence_analyzer/
├── backend/
│   ├── auth-service/
│   │   ├── src/
│   │   │   ├── main/
│   │   │   │   ├── java/com/mutlukodcu/kkka/auth/
│   │   │   │   │   ├── AuthServiceApplication.java
│   │   │   │   │   ├── config/
│   │   │   │   │   │   ├── SecurityConfig.java
│   │   │   │   │   │   └── JwtUtil.java
│   │   │   │   │   ├── controller/
│   │   │   │   │   │   └── AuthController.java
│   │   │   │   │   ├── dto/
│   │   │   │   │   │   ├── LoginRequest.java
│   │   │   │   │   │   └── RegisterRequest.java
│   │   │   │   │   ├── model/
│   │   │   │   │   │   └── User.java
│   │   │   │   │   ├── repository/
│   │   │   │   │   │   └── UserRepository.java
│   │   │   │   │   ├── security/
│   │   │   │   │   │   ├── JwtAuthenticationFilter.java
│   │   │   │   │   │   └── JwtAuthorizationFilter.java
│   │   │   │   │   └── service/
│   │   │   │   │       └── AuthService.java
│   │   │   │   └── resources/
│   │   │   │       ├── application.yml
│   │   │   │       └── static/
│   │   │   └── test/java/com/mutlukodcu/kkka/auth/
│   │   │       └── AuthServiceTests.java
│   │   ├── Dockerfile
│   │   ├── pom.xml
│   │   └── README.md
│   │
│   ├── kafka-consumer-service/
│   │   ├── src/
│   │   │   ├── main/
│   │   │   │   ├── java/com/mutlukodcu/kkka/kafkaconsumer/
│   │   │   │   │   ├── KafkaConsumerApplication.java
│   │   │   │   │   ├── config/
│   │   │   │   │   │   └── KafkaConsumerConfig.java
│   │   │   │   │   ├── consumer/
│   │   │   │   │   │   └── GeneSequenceKafkaListener.java
│   │   │   │   │   ├── model/
│   │   │   │   │   │   └── GeneSequencePayload.java
│   │   │   │   │   ├── service/
│   │   │   │   │   │   └── AnalysisProcessorService.java
│   │   │   │   │   └── util/
│   │   │   │   │       └── LoggingUtils.java
│   │   │   │   └── resources/
│   │   │   │       └── application.yml
│   │   │   └── test/java/com/mutlukodcu/kkka/kafkaconsumer/
│   │   │       └── KafkaConsumerServiceTests.java
│   │   ├── Dockerfile
│   │   ├── pom.xml
│   │   └── README.md
│   │
│   ├── gene-upload-service/
│   │   ├── src/main/java/com/mutlukodcu/kkka/geneupload/
│   │   │   ├── GeneUploadApplication.java
│   │   │   ├── config/
│   │   │   ├── controller/
│   │   │   ├── dto/
│   │   │   ├── model/
│   │   │   ├── repository/
│   │   │   └── service/
│   │   └── resources/application.yml
│   │   ├── Dockerfile
│   │   ├── pom.xml
│   │   └── README.md
│   │
│   ├── analysis-service/
│   │   ├── src/
│   │   │   ├── main/
│   │   │   │   ├── java/com/mutlukodcu/kkka/analysis/
│   │   │   │   │   ├── AnalysisServiceApplication.java
│   │   │   │   │   ├── config/
│   │   │   │   │   │   └── KafkaProducerConfig.java
│   │   │   │   │   ├── controller/
│   │   │   │   │   │   └── AnalysisController.java
│   │   │   │   │   ├── dto/
│   │   │   │   │   │   └── AnalysisRequestDTO.java
│   │   │   │   │   ├── model/
│   │   │   │   │   │   └── AnalysisResult.java
│   │   │   │   │   ├── repository/
│   │   │   │   │   │   └── AnalysisResultRepository.java
│   │   │   │   │   ├── service/
│   │   │   │   │   │   └── AnalysisService.java
│   │   │   │   │   ├── util/
│   │   │   │   │   │   └── BayesAnalyzer.java
│   │   │   │   │   └── exception/
│   │   │   │   │       └── AnalysisException.java
│   │   │   │   └── resources/
│   │   │   │       ├── application.yml
│   │   │   │       └── static/
│   │   │   └── test/
│   │   │       └── java/com/mutlukodcu/kkka/analysis/
│   │   │           └── AnalysisServiceTests.java
│   │   ├── Dockerfile
│   │   ├── pom.xml
│   │   └── README.md
│   │
│   ├── report-service/
│   │   ├── src/
│   │   │   ├── main/
│   │   │   │   ├── java/com/mutlukodcu/kkka/report/
│   │   │   │   │   ├── ReportServiceApplication.java
│   │   │   │   │   ├── config/
│   │   │   │   │   │   └── SwaggerConfig.java
│   │   │   │   │   ├── controller/
│   │   │   │   │   │   └── ReportController.java
│   │   │   │   │   ├── dto/
│   │   │   │   │   │   └── ReportRequestDTO.java
│   │   │   │   │   ├── service/
│   │   │   │   │   │   └── ReportService.java
│   │   │   │   │   ├── util/
│   │   │   │   │   │   └── ExcelExporter.java
│   │   │   │   │   └── exception/
│   │   │   │   │       └── ReportException.java
│   │   │   │   └── resources/
│   │   │   │       ├── application.yml
│   │   │   │       └── static/
│   │   │   └── test/
│   │   │       └── java/com/mutlukodcu/kkka/report/
│   │   │           └── ReportServiceTests.java
│   │   ├── Dockerfile
│   │   ├── pom.xml
│   │   └── README.md
│   │
│   ├── gensequenceanalyzer/
│   │   ├── src/main/java/com/mutlukodcu/kkka/gensequenceanalyzer/
│   │   │   ├── GenSequenceAnalyzerApplication.java
│   │   │   ├── config/
│   │   │   ├── controller/
│   │   │   ├── dto/
│   │   │   ├── exception/
│   │   │   ├── kafka/
│   │   │   ├── model/
│   │   │   ├── repository/
│   │   │   ├── security/
│   │   │   ├── service/
│   │   │   └── util/
│   │   └── resources/application.yml
│   │
│   ├── api-gateway/
│   │   ├── src/main/java/com/mutlukodcu/kkka/gateway/
│   │   │   ├── ApiGatewayApplication.java
│   │   │   ├── config/
│   │   │   ├── filter/
│   │   │   └── route/
│   │   └── resources/application.yml
│   │   ├── Dockerfile
│   │   ├── pom.xml
│   │   └── README.md
│   │
│   ├── shared-lib/
│   │   ├── src/main/java/com/mutlukodcu/kkka/shared/
│   │   │   ├── constants/
│   │   │   │   └── AppConstants.java
│   │   │   ├── dto/
│   │   │   │   ├── GeneSequenceDTO.java
│   │   │   │   ├── AnalysisResultDTO.java
│   │   │   │   └── UserDTO.java
│   │   │   ├── kafka/
│   │   │   │   └── events/
│   │   │   │       └── GeneSequenceEvent.java
│   │   │   └── utils/
│   │   │       └── DateUtils.java
│   │   └── resources/
│   │       └── application.yml
│   │   ├── pom.xml
│   │   └── README.md
│   │
│   ├── discovery-service/
│   │   ├── src/
│   │   │   ├── main/
│   │   │   │   ├── java/com/mutlukodcu/kkka/discovery/
│   │   │   │   │   ├── DiscoveryApplication.java
│   │   │   │   │   ├── config/
│   │   │   │   │   │   └── EurekaServerConfig.java
│   │   │   │   │   └── controller/
│   │   │   │   │       └── HealthCheckController.java
│   │   │   │   └── resources/
│   │   │   │       ├── application.yml
│   │   │   │       └── bootstrap.yml
│   │   │   └── test/
│   │   │       └── java/com/mutlukodcu/kkka/discovery/
│   │   │           └── DiscoveryServiceTests.java
│   │   ├── Dockerfile
│   │   ├── pom.xml
│   │   └── README.md
│   │
│   └── notification-service/
│       ├── src/main/java/com/mutlukodcu/kkka/notification/
│       │   ├── NotificationApplication.java
│       │   ├── config/
│       │   ├── controller/
│       │   ├── dto/
│       │   ├── model/
│       │   ├── repository/
│       │   └── service/
│       └── resources/application.yml
│       ├── Dockerfile
│       ├── pom.xml
│       └── README.md
│
├── frontend/
│   ├── public/
│   └── src/
│       ├── components/
│       ├── pages/
│       ├── services/
│       └── utils/
│   ├── package.json
│   ├── README.md
│   └── vite.config.js
│
├── docs/
│   ├── architecture-diagram.puml
│   ├── uml-class-diagram.puml
│   ├── er-diagram.puml
│   ├── sequence-diagram.puml
│   └── README.md
│
├── docker-compose.yml
├── init.sql
├── Makefile
├── README.md
└── LICENSE


```

## 🧪 Sistem Özellikleri

- JWT ile kullanıcı yetkilendirmesi ve giriş sistemi
- Gen sekansı yükleme, analiz etme, risk puanı hesaplama
- Kafka ile asenkron analiz iş akışı
- PostgreSQL üzerinde analizlerin saklanması
- Excel çıktısı alma (Apache POI)
- Swagger ile REST API dokümantasyonu
- Harita ve grafiklerle analiz sonuçlarının sunumu (Frontend

## 📌 Uygulama Akışı
* Kullanıcı Girişi (auth-service) :
	JWT tabanlı giriş (Admin, Analyst rolleri)
	Spring Security ile korunmuş uç noktalar
* Gen Verisi Yükleme (gene-upload-service)
	Kullanıcı bir gen sekansı dosyası (Excel/JSON/FASTA) yükler
	Apache POI ile işlenir ve Kafka’ya gönderilir
* Genetik Risk Analizi (analysis-service)
	Kafka Consumer gelen veriyi alır
	Bayes Modeli ile belirlenen gen motifleriyle eşleşme oranı bulunur
	Risk skoru hesaplanır (% olasılık)
	PostgreSQL’de saklanır
* Raporlama ve Excel Çıktısı (report-service)
	Kullanıcı analiz geçmişini görür
	Tek tıkla Excel çıktısı alabilir (Apache POI)
* Frontend
	ReactJS tabanlı kullanıcı arayüzü
	Bootstrap 5 ile şık ve kullanıcı dostu sayfalar
	Analiz sonucu: renkli grafikler, risk yüzdesi, öneriler
* Bayes (calculateBayesianRisk)
	Prior: Gen mutasyonu taşıma olasılığı (öncül) = 0.01
	Likelihood: Bu mutasyonu taşıyanların hastalığı geliştirme olasılığı = 0.8
	Evidence: Toplam popülasyonda hastalık oranı = 0.05
* Kafka Flow
	Dosya yüklendiğinde gene-upload-service → Kafka Producer
	analysis-service → Kafka Consumer → analiz yap → sonucu PostgreSQL’e kaydet
* Docker Compose
* 
```
	version: '3.8'
	services:
	  postgres:
		image: postgres:14
		environment:
		  POSTGRES_DB: gene_db
		  POSTGRES_USER: user
		  POSTGRES_PASSWORD: pass
	  kafka:
		image: bitnami/kafka:latest
	  zookeeper:
		image: bitnami/zookeeper:latest
	  auth-service:
		build: ./backend/auth-service
	  analysis-service:
		build: ./backend/analysis-service
	  frontend:
		build: ./frontend
```

## 📊 Diyagramlar

Aşağıdaki diyagramlar `docs/` klasöründe yer almaktadır ve proje mimarisini belgelemektedir:

- `architecture-diagram.puml` → Projenin genel mimari yapısı
- `uml-class-diagram.puml` → Backend sınıf yapısı
- `er-diagram.puml` → Veritabanı ilişkileri
- `sequence-diagram.puml` → Gen sekansı analiz iş akışı


## 🚀 Kurulum

```bash
git clone https://github.com/mutlukodcu/mutlukodcu_kkka_gen_sequence_analyzer.git
cd mutlukodcu_kkka_gen_sequence_analyzer
docker-compose up --build
```

Telif Hakkı © 2025 Mutlu Kodcu
