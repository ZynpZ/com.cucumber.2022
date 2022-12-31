@db
Feature: JDBC kullanarak yeterli bilgi ile database testi yapilabilir

  Scenario: JDBC01 kullanici databasede sorgu yapabilmeli

    Given Kullanici JDBC ile database'e baglanir
    Then  users tablosundaki isim verilerini alir
    And isim verilerini test eder