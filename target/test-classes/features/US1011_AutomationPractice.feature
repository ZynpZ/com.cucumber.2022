Feature: US1011 Automation Practice Kullanici Olusturma Testi
@wip
  Scenario: TC18 Kullanici yeni kullanici olusturabilmeli

    Given Kullanici "automationUrl" anasayfaya gider
    And user signUp linkine tiklar
    And New user bölümüne name ve email adresi girer
    And SignUp butonuna basar
    And user kisisel bilgilerini ve iletisim bilgilerinin girer
    And user create acccount butonuna basar
    Then hesap olustugunu dogrulayin