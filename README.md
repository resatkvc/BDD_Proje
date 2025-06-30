# BDD_Proje

## Proje Amacı
Bu proje, BDD (Behavior Driven Development) yaklaşımıyla, Selenium WebDriver ve JUnit kullanarak https://editor.datatables.net/ sitesinde kayıt oluşturma ve arama işlemlerinin otomasyonunu gerçekleştirmek için hazırlanmıştır.

## Klasör Yapısı
```
BDD_Proje/
├── pom.xml
├── README.md
├── src/
│   ├── main/
│   │   └── java/
│   └── test/
│       ├── java/
│       │   ├── pages/                # Page Object Model sınıfları
│       │   ├── runners/              # Cucumber test runner
│       │   └── stepdefinitions/      # Step definition dosyaları
│       └── resources/
│           ├── config.properties     # Test verileri ve baseUrl
│           └── features/             # Feature dosyaları (Gherkin)
```

## Senaryo Özeti
- Kullanıcı ana sayfaya gider.
- Yeni bir kayıt oluşturur (veriler config dosyasından alınır).
- Oluşturulan kaydı arar.
- Kaydın listede olduğunu doğrular.

## Notlar
- Farklı ortamlar veya test verileri için sadece `config.properties` dosyasını değiştirmeniz yeterlidir.
