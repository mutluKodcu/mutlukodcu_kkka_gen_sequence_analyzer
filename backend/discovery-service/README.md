# Discovery Service

`discovery-service`, Kırım Kongo Kanamalı Ateşi (KKKA) biyoinformatik analiz platformu için mikroservislerin dinamik keşfi ve kayıt işlemlerini yöneten Eureka Server tabanlı bir servis keşif modülüdür.

## Genel Bakış

Bu servis, platformdaki diğer mikroservislerin kendilerini otomatik olarak kaydedip keşfedilmesini sağlar. Böylece servisler arası iletişim ve yük dengeleme kolaylaşır. Spring Cloud Netflix Eureka Server teknolojisi kullanılarak geliştirilmiştir.

---

## Özellikler

- **Eureka Server:** Mikroservis kayıt ve keşif işlemlerini yönetir.
- **Sağlık Kontrolü:** `/health` endpoint’i ile servis durumu ve JVM bilgisi sağlar.
- **Docker Desteği:** Dockerfile ile konteynerize edilerek kolay dağıtım.
- **Yüksek Erişilebilirlik:** Eureka cluster yapısına uygun olarak genişletilebilir.
- **Basit Konfigürasyon:** YAML tabanlı ayar dosyalarıyla kolay yapılandırma.

---

## Teknolojiler

- Java 17
- Spring Boot 3.x
- Spring Cloud Netflix Eureka Server
- Maven
- Docker

---

## Kurulum ve Çalıştırma

### Maven ile

Projeyi klonladıktan sonra:

```bash
cd discovery-service
./mvnw clean install
./mvnw spring-boot:run
```
## Docker ile çalıştırma
docker build -t discovery-service .
docker run -p 8761:8761 discovery-service
## Yapılandırma
src/main/resources/application.yml dosyasında veritabanı ve güvenlik ayarları bulunmaktadır.

## Test
src/test/java dizininde birim testler yer almaktadır.

##  API Endpoints
- GET /health
```
JSON :
	{
	  "status": "UP",
	  "application": "discovery-service",
	  "version": "1.0.0",
	  "jvmName": "OpenJDK 64-Bit Server VM",
	  "jvmVersion": "17.0.8+7",
	  "uptime": "1234567 ms",
	  "startTime": 1687790200000
	}
	```
