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
}



