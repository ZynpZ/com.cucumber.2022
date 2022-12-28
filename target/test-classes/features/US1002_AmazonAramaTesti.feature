@Paralel1
Feature: US1002_Amazon Arama Testi


      #Kullanicinin arama yapması için 3 scenereio oluştur.
      # Nutella, Java ve Apple için arama yapıp sonuçların aranan kelime içerdiğini test edin.


    Scenario: TC02 Kullanici amazonda Nutella aramasi yapar
      Given Kullanici amazon anasayfaya gider
      Then Arama cubuguna Nutella yazip aratir
      And Arama sonuclarinin Nutella icerdigini test eder
      And Sayfayi kapatir

    Scenario: TC03 Kullanici amazonda Java aramasi yapar
      Given Kullanici amazon anasayfaya gider
      Then Arama cubuguna Java yazip aratir
      And Arama sonuclarinin Java icerdigini test eder
      And Sayfayi kapatir

    Scenario: TC03 Kullanici amazonda Apple aramasi yapar
      Given Kullanici amazon anasayfaya gider
      Then Arama cubuguna Apple yazip aratir
      And Sonuclarin Apple icerdigini test eder
      And Sayfayi kapatir