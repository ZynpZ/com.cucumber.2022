package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class AmazonStepDefinitions {
    AmazonPage amazonPage = new AmazonPage();

    @Given("Kullanici amazon anasayfaya gider")
    public void kullanici_amazon_anasayfaya_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
    }
    @When("Arama cubuguna Nutella yazip aratir")
    public void arama_cubuguna_nutella_yazip_aratir() {
        amazonPage.aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
    }
    @Then("Arama sonuclarinin Nutella icerdigini test eder")
    public void arama_sonuclarinin_nutella_icerdigini_test_eder() {
        String actualAramaSonucu = amazonPage.aramaSonucElementi.getText();
        String expectedkelime = "Nutella";
        Assert.assertTrue(actualAramaSonucu.contains(expectedkelime));
    }
    @Then("Sayfayi kapatir")
    public void sayfayi_kapatir() {
        Driver.closeDriver();
    }

    @Then("Arama cubuguna Java yazip aratir")
    public void aramaCubugunaJavaYazipAratir() {
        amazonPage.aramaKutusu.sendKeys("Java" + Keys.ENTER);
    }

    @And("Arama sonuclarinin Java icerdigini test eder")
    public void aramaSonuclarininJavaIcerdiginiTestEder() {
        String actualAramaSonucu = amazonPage.aramaSonucElementi.getText();
        String expectedkelime = "Java";
        Assert.assertTrue(actualAramaSonucu.contains(expectedkelime));

    }

    @Then("Arama cubuguna Apple yazip aratir")
    public void aramaCubugunaAppleYazipAratir() {
        amazonPage.aramaKutusu.sendKeys("Apple" + Keys.ENTER);
    }

    @And("Sonuclarin Apple icerdigini test eder")
    public void sonuclarinAppleIcerdiginiTestEder() {
        String actualAramaSonucu = amazonPage.aramaSonucElementi.getText();
        String expectedkelime = "Apple";
        Assert.assertTrue(actualAramaSonucu.contains(expectedkelime));
    }

    @Then("Arama cubuguna {string} yazip aratir")
    public void aramaCubugunaYazipAratir(String istenenKelime) {
        amazonPage.aramaKutusu.sendKeys(istenenKelime + Keys.ENTER);
    }

    @And("Arama sonuclarinin {string} icerdigini test eder")
    public void aramaSonuclarininIcerdiginiTestEder(String istenenKelime) {
        String actualAramaSonucu = amazonPage.aramaSonucElementi.getText();
        Assert.assertTrue(actualAramaSonucu.contains(istenenKelime));
    }

    @Given("Kullanici {string} anasayfaya gider")
    public void kullaniciAnasayfayaGider(String istenenUrl) {

        Driver.getDriver().get(ConfigReader.getProperty(istenenUrl));
    }

    @Then("url'in {string} icerdigini test eder")
    public void urlInIcerdiginiTestEder(String istenenKelime) {
        String actualUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(istenenKelime));
    }
}



