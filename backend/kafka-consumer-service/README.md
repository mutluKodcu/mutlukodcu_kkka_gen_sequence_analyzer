# Kafka Consumer Service

Bu mikroservis, Kafka üzerinden gelen gen dizisi verilerini dinleyerek işleyen ve analiz servisine gönderen tüketici servisidir.

## Özellikler
- Kafka mesajlarını dinler.
- Gelen gen dizisi verisini alır, işler.
- Analiz servisine veri gönderme işlemlerini yönetir.
- PostgreSQL veri tabanı ile entegre çalışır.

## Gereksinimler
- Java 17
- Maven
- Kafka
- PostgreSQL

## Çalıştırma
### Maven ile
```bash
mvn clean package
mvn spring-boot:run
```

## Docker ile 
	docker build -t kafka-consumer-service .
	docker run -p 8085:8085 kafka-consumer-service
## API
Bu servis API sunmaz, Kafka mesajları ile çalışır.

## Proje Yapısı
	src/main/java/com/mutlukodcu/kkka/kafkaconsumer/ kaynak kodları
	config/ Kafka yapılandırmaları
	consumer/ Kafka listener sınıfları
	service/ iş mantığı
	model/ veri modelleri
	util/ yardımcı sınıflar