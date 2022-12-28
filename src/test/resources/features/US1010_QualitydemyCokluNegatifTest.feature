
Feature: US1010 Liste olarak verilen wrong user ile negatif login testi

  Scenario Outline:

    Given Kullanici "myUrl" anasayfaya gider
    Then myCourse anasayfa login linkine tiklar
    And myCourse kullanici adi olarak "<istenenEmail>" girer
    Then myCourse password olarak "<istenenPassword>" girer
    Then myCourse login butonuna basar
    And myCourse giris yapilmadigini test eder
    Then Sayfayi kapatir

    Examples:
    |istenenEmail|istenenPassword|
    |myYanlisEmail|myYanlisPassword|
    |myYanlisEmail1|myYanlisPassword1|
    |myYanlisEmail2|myYanlisPassword2|
    |myYanlisEmail3|myYanlisPassword3|
    |myYanlisEmail4|myYanlisPassword4|
