package example;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import example.system.Initialization;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BrowserStackAuth {

    Initialization init = new Initialization();

    public void testALoginFormPlusFirstEquipment() throws MalformedURLException {

        WebDriverRunner.setWebDriver(init.browserStack());

        $(By.id("com.universalelectric.app:id/spinnerCompany")).click();
        $$(By.id("com.universalelectric.app:id/textViewWorkshopExpanded"))
                .findBy(text("НеТрогать"))
                .click();
        $(By.id("com.universalelectric.app:id/spinnerWorkshop")).click();
        $$(By.id("com.universalelectric.app:id/textViewWorkshopExpanded"))
                .findBy(text("ЛВС"))
                .click();
        $(By.id("com.universalelectric.app:id/spinnerPavilion")).click();
        $$(By.id("com.universalelectric.app:id/textViewWorkshopExpanded"))
                .findBy(text("ГИДС"))
                .click();

        $(By.id("com.universalelectric.app:id/autoCompleteTextViewUser")).sendKeys("Сергеев Сергей Сергеевич");
        AndroidDriver driver = (AndroidDriver) WebDriverRunner.getWebDriver();
        driver.hideKeyboard();

        $(By.id("com.universalelectric.app:id/buttonLogin")).click();

        $(By.id("com.universalelectric.app:id/buttonKey1")).click();
        $(By.id("com.universalelectric.app:id/buttonKey1")).click();
        $(By.id("com.universalelectric.app:id/buttonKey1")).click();
        $(By.id("com.universalelectric.app:id/buttonKey1")).click();

        Configuration.timeout = 10000;
        $(By.className("android.widget.RelativeLayout")).shouldNotBe(visible);
        Configuration.timeout = 4000;

        $(By.id("com.universalelectric.app:id/bypassListFragment")).click();
        $$(By.id("com.universalelectric.app:id/buttonBypass"))
                .find(Condition.text("Начать обход"))
                .click();

        WebDriverRunner.closeWebDriver();
    }

}
