# Temel imaj olarak OpenJDK 17 kullanıyoruz
FROM openjdk:17-jdk-slim

# Uygulama jar dosyasını konteynere kopyala
ARG JAR_FILE=target/auth-service-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar

# Uygulamayı çalıştır
ENTRYPOINT ["java","-jar","/app.jar"]

# Varsayılan port
EXPOSE 8081
