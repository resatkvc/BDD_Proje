Feature: Kayıt oluşturma ve arama işlemleri

  Background:
    Given Kullanıcı ana sayfaya gider

  Scenario: Yeni kayıt oluşturma ve arama
    When Kullanıcı yeni bir kayıt oluşturur
    And Kullanıcı oluşturduğu kaydı arar
    Then Oluşturulan kaydın listede olduğunu doğrular 