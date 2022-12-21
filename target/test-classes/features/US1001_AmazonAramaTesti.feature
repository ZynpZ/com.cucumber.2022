Feature: US1001 Amazon arama testi
  @wip

  Scenario: TC01 Kullanici Amazonda arama yapabilmeli

    Given Kullanici amazon anasayfaya gider
    When Arama cubuguna Nutella yazip aratir
    Then Arama sonuclarinin Nutella icerdigini test eder
    And Sayfayi kapatir

  Scenario: TC03 Kullanici amazonda Java aramasi yapar

    Given Kullanici amazon anasayfaya gider
    Then Arama cubuguna Java yazip aratir
    And Arama sonuclarinin Java icerdigini test eder
    And Sayfayi kapatir