package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

public class Hooks {
    /*
    TestNG projemizde veya JUnit projemizde her class'dan veya method'dan önce veya sonra
    çalışmasını istediğimiz method olsaydı

    ya içinde bulunduğumuz class'da bir @Before... @After... oluştururduk
    ya da extends ile bir class'ı parent edinip o class'a @Before... @After... koyuyorduk

    Cucumber'da çalışacak metotlar bir class'la sınırlı değildir.
    Stepdefinitions klasörü altındaki tüm class'lardaki methodlar çalıştırılabilir.

    Eğer bizim bütün testlerimiz için herhangi bir @Before... @After... methoduna ihtiyacımız varsa
    stepdefinitions altında herhangi bir class'a koymamız yeterli olacaktır.

    Projeler kollektif çalışıldığından ekipteki herkesin yerini bulabilmesi için
    @Before... @After... methodları kullanılacaksa
    Hooks classına konulması genel kullanım olarak benimsenmiştir.

     */
    @After
    public void tearDown(Scenario scenario) {

        final byte[] screenshot=((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        if (scenario.isFailed()) {
            scenario.attach(screenshot,"image/png","screenshot");
        }
        Driver.closeDriver();
    }

}
