@myCourse
Feature: US1006 Doğru Kullanıcı adı ve password ile pozitif login testi

  Scenario: TC12 Kullanici mycoursedemy sitesine giriş yapabilmeli

    Given Kullanici "myUrl" anasayfaya gider
    Then myCourse anasayfa login linkine tiklar
    And myCourse kullanici adi olarak "myGecerliEmail" girer
    And myCourse password olarak "myGecerliPassword" girer
    And myCourse login butonuna basar
    Then myCourse giris yapabildigini test eder
    And Sayfayi kapatir