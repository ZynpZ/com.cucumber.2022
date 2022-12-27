
Feature: US1009 Kullanıcı liste olarak verilen ürünleri Amazon'da aratır

  #Amazon ana sayfaya gidip Nutella, java, Apple, Samsung, LG için arama yapıp
  #arama sonuclarının aranan kelimeleri içerdiğini test edin

  Scenario Outline: TC17 Kullanıcı liste olarak arama testi yapabilmeli

    Given Kullanici "amazonUrl" anasayfaya gider
    Then Arama cubuguna "<istenenKelime>" yazip aratir
    And Arama sonuclarinin "<istenenKelime>" icerdigini test eder
    Then Sayfayi kapatir

    Examples:
    |istenenKelime|
    |Nutella      |
    |Java         |
    |Apple        |
    |Samsung      |
    |LG           |



