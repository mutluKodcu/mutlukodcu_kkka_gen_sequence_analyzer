# Temel imaj olarak açık kaynaklı bir JDK 17 imajı kullanılır
FROM eclipse-temurin:17-jdk-jammy

# Uygulama jar dosyası için çalışma dizini oluşturulur
WORKDIR /app

# Maven build sonrası oluşturulan jar dosyasını konteynıra kopyala
COPY target/kafka-consumer-service-0.0.1-SNAPSHOT.jar app.jar

# Uygulama portu
EXPOSE 8085

# Uygulamayı çalıştır
ENTRYPOINT ["java", "-jar", "app.jar"]
