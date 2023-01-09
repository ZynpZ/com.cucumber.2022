
Feature: US1008 Herokuapp Wait Testleri

  Scenario: TC16 Kullanici wait islemlerinin calistigini test eder

    Given Kullanici "herokuUrl" anasayfaya gider
    Then Herokuapp Add Element butonuna
    And Herokuapp Delete butonu gorunmesini bekler
    And Delete butonunun gorunur olduğunu test eder
    Then Herokuapp Delete butonuna basarak butonu siler
    And Herokuapp Delete butonunun gorunmedigini test eder
    Then Sayfayi kapatir

    #Yeni bir sayfada calısmaya basladığımızda
  # 1- Feature dosyası olusturalım
  # 2- Eksik adımları olusturmak icin
  #   Runner class'ında dryRun=true yapıp, Runner'ı calıstıralım. olusturulan eksik adımları,
  #   Yeni bir class olusturup icerisine yapıstıralım
  # 3- Stepdefinitions class'ındaki eksik adımların java kodlarını POM'a uygun olarak yazalım
  # 4- Locate'leri yapmak için page sayfası oluşturalım
  #    Page classını acınca bir constructor olusturup,
  #    Pagefactory.initElements() methodu'nu kullanarak Driver'ımızı page sayfasına tanıtalım