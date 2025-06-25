# Diyagramlar ve Kullanımı

Bu klasörde proje için hazırlanmış 4 adet PlantUML diyagram dosyası bulunmaktadır:

- architecture-diagram.puml       : Proje mimari diyagramı
- uml-class-diagram.puml          : UML sınıf diyagramı
- er-diagram.puml                 : Entity-Relationship diyagramı
- sequence-diagram.puml           : Sequence diyagramı

## PNG'ye Dönüştürme

Diyagramları görüntülemek için [PlantUML](https://plantuml.com/) kullanabilirsiniz. Aşağıdaki yöntemlerden birini seçebilirsiniz:

### 1. Online

- https://www.plantuml.com/plantuml/uml/ adresine gidin.
- .puml dosyasındaki kodu yapıştırın.
- PNG formatında diyagramı indirin.

### 2. Yerel Araçlar

- Java yüklü ise, PlantUML jar dosyasını indirip çalıştırabilirsiniz.
- Komut satırından:
  ```
  java -jar plantuml.jar dosyaadi.puml
  ```
- Bu işlem .puml dosyası ile aynı klasörde PNG dosyası oluşturur.

## Kullanım

Oluşan PNG dosyalarını `docs/` klasörüne koyup README'de referans verebilir veya proje dokümantasyonunda kullanabilirsiniz.