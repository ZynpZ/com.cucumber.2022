package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.AutomationPage;
import utilities.Driver;

import java.security.Key;

public class AutomationStepdefinitions {

    AutomationPage automationPage=new AutomationPage();

    @Given("user signUp linkine tiklar")
    public void user_sign_up_linkine_tiklar() {
        automationPage.signUpLinki.click();
    }
    @Given("New user bölümüne name ve email adresi girer")
    public void new_user_bölümüne_name_ve_email_adresi_girer() {
        automationPage.isimKutusu.sendKeys("zelzeleeeel");
        automationPage.emailKutusu.sendKeys("zelel@gmail.com");
    }
    @Given("SignUp butonuna basar")
    public void sign_up_butonuna_basar() {
        automationPage.signUpButonu.click();
    }
    @Given("user kisisel bilgilerini ve iletisim bilgilerinin girer")
    public void user_kisisel_bilgilerini_ve_iletisim_bilgilerinin_girer() {

       Actions actions=new Actions(Driver.getDriver());
       actions.click(automationPage.erkekTitleradioButton)
               .sendKeys(Keys.TAB).sendKeys(Keys.TAB)
               .sendKeys("123456").sendKeys(Keys.TAB)
               .sendKeys("25").sendKeys(Keys.TAB)
               .sendKeys("May").sendKeys(Keys.TAB)
               .sendKeys("1990")
               .sendKeys(Keys.TAB)
               .sendKeys(Keys.ARROW_DOWN)
               .sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
               .sendKeys(Keys.ARROW_DOWN)
               .sendKeys(Keys.TAB)
               .sendKeys(Keys.TAB).sendKeys("can")
                .sendKeys(Keys.TAB)
                .sendKeys("xry")
                .sendKeys(Keys.TAB)
                .sendKeys("ISVEC")
                .sendKeys(Keys.TAB)
                .sendKeys("huddinge/Stockholm")
                .sendKeys(Keys.TAB)
                .sendKeys("-")
                .sendKeys(Keys.TAB)
                .sendKeys("New Zealand")
                .sendKeys(Keys.TAB)
                .sendKeys("-")
                .sendKeys(Keys.TAB)
                .sendKeys("Stockholm")
                .sendKeys(Keys.TAB)
                .sendKeys("12321")
                .sendKeys(Keys.TAB)
                .sendKeys("+4623232323").sendKeys(Keys.TAB).sendKeys(Keys.ENTER)
                .perform();
    }
    @Given("user create account butonuna basar")
    public void user_create_account_butonuna_basar() {
       // automationPage.createAccountButonu.click();
    }
    @Then("hesap olustugunu dogrulayin")
    public void hesap_olustugunu_dogrulayin() {
        Assert.assertTrue(automationPage.createAccountButonu.isDisplayed());


    }


}
