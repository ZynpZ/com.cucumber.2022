package stepdefinitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.HerokuappPage;
import utilities.ReasuableMethods;

import java.util.NoSuchElementException;

public class HerokuappStepdefinitions {

    HerokuappPage herokuappPage=new HerokuappPage();
    @Then("Herokuapp Add Element butonuna")
    public void herokuapp_add_element_butonuna() {
        herokuappPage.addButonu.click();
    }
    @Then("Herokuapp Delete butonu gorunmesini bekler")
    public void herokuapp_delete_butonu_gorunmesini_bekler() {
        //delete butonu 15 saniyelik implicitlyWait süresi içerisinde göründüğünden ekstra explicit wait olusturmaya gerek yok
        // illa da kullanılmak isteniyorsa
        ReasuableMethods.bekle(3);
    }
    @Then("Delete butonunun gorunur olduğunu test eder")
    public void delete_butonunun_gorunur_olduğunu_test_eder() {
        Assert.assertTrue(herokuappPage.deleteButton.isDisplayed());

    }
    @Then("Herokuapp Delete butonuna basarak butonu siler")
    public void herokuapp_delete_butonuna_basarak_butonu_siler() {
        herokuappPage.deleteButton.click();

    }
    @Then("Herokuapp Delete butonunun gorunmedigini test eder")
    public void herokuapp_delete_butonunun_gorunmedigini_test_eder() {
        boolean flag=false;

        try {
            Assert.assertFalse(herokuappPage.deleteButton.isDisplayed());
        } catch (Exception e) {
           flag=true;
        }
        Assert.assertTrue(flag);

    }

}
