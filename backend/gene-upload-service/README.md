# Gene Upload Service

Bu servis, kullanıcıların genetik veri (Excel, JSON, FASTA) yüklemelerine olanak tanır ve bu verileri analiz için hazırlar.

## Özellikler

- Excel ve metin dosyalarından gen sekansı alma
- JPA ile veri kaydetme
- REST API ile yükleme arayüzü
- Apache POI ile Excel işleme

## Gereksinimler

- Java 17
- Maven
- PostgreSQL
- Kafka (isteğe bağlı)

## Derleme ve Çalıştırma

### Maven

```
mvn clean install
```

### Docker

```
docker build -t gene-upload-service .
docker run -p 8082:8082 gene-upload-service
```

## API Kullanımı

### `POST /api/upload`

Form-data ile `file` (Excel, JSON, FASTA) gönder.

#### Yanıt:
```json
{
  "message": "Dosya başarıyla alındı ve işlendi.",
  "geneCount": 14
}
```

## Dizin Yapısı

```
gene-upload-service/
├── controller/
├── service/
├── model/
├── dto/
├── repository/
├── config/
└── util/
```

## Lisans

MIT License
