# Auth Service

Bu modül, kullanıcı kimlik doğrulama, JWT tabanlı yetkilendirme ve rol yönetimi için geliştirilmiş mikroservistir.

## Teknolojiler
- Java 17
- Spring Boot 3
- Spring Security + JWT
- PostgreSQL + JPA / Hibernate

## Özellikler
- Kullanıcı kayıt ve giriş işlemleri
- JWT ile güvenli token tabanlı kimlik doğrulama
- Rol bazlı erişim kontrolü

## Çalıştırma

### Maven ile derleme
```bash
mvn clean install
```bash

## Docker ile çalıştırma
	docker build -t auth-service .
	docker run -p 8081:8081 auth-service
## Yapılandırma
src/main/resources/application.yml dosyasında veritabanı ve güvenlik ayarları bulunmaktadır.

## Test
src/test/java dizininde birim testler yer almaktadır.
