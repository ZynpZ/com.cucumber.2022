@wip
Feature: US1005 Parametreli Configuration Properties Kullanimi

  #3 farkli senaryo oluşturun
  #amazon, mycoursedemy ve wisequarter anasayfalarına gidip
  #url'nin bu kelimeleri içerdiğini test eder.

  Scenario: TC09 kullanici amazon anasayfasına gidebilmeli
    Given Kullanici "amazonUrl" anasayfaya gider
    Then url'in "amazon" icerdigini test eder
    And Sayfayi kapatir

  Scenario: TC11 kullanici mycoursedemy anasayfasına gidebilmeli
    Given Kullanici "myUrl" anasayfaya gider
    Then url'in "mycoursedemy" icerdigini test eder
    And Sayfayi kapatir

  Scenario: TC11 kullanici wisequarter anasayfasına gidebilmeli
    Given Kullanici "wiseUrl" anasayfaya gider
    Then url'in "wisequarter" icerdigini test eder
    And Sayfayi kapatir