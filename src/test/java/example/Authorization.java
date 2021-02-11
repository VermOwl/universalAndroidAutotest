package example;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import example.system.Initialization;
import io.appium.java_client.android.AndroidElement;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import org.openqa.selenium.interactions.Actions;



public class Authorization {

    Initialization init = new Initialization();

    int range_vibration = (3 - 0) + 0;
    int range_amperage = (104 - 75 + 1) + 75;
    int range_temperature = (29 - (-50) + 1 ) + (-50);
    int range_ibp_zu_tvu_1 = (413 - 305 + 1) + 305;
    int range_ibp_zu_tvu_2 = (250 - 189 + 1) + 189;

    public String getValue(int max, int min){
        double random_double = Math.random() * (max - min + 1) + min;
        String test = String.format("%.2f", random_double);
        String final_value = test.replace(',','.');
        return final_value;
    }

    @Test
    public void loginForm() throws MalformedURLException {

        WebDriverRunner.setWebDriver(init.initialization());

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
    }

    @Test
    public void testFirstEquipment() throws MalformedURLException{

        WebDriverRunner.setWebDriver(init.connectToDevice());

        AndroidDriver driver = (AndroidDriver) WebDriverRunner.getWebDriver();
        Actions actions = new Actions(driver);

        actions.clickAndHold($$(By.id("com.universalelectric.app:id/buttonBypass"))
                .find(Condition.text("Начать обход"))).perform();

        actions.dragAndDropBy(
                $(By.id("com.universalelectric.app:id/textViewQuestionNumber")),
                0,
                -500
                ).perform();


        $$(By.className("android.widget.EditText"))
                .find(Condition.text("Вибродиагностика 1"))
                .sendKeys(getValue(0 ,3));

        $$(By.className("android.widget.EditText"))
                .find(Condition.text("Вибродиагностика 2"))
                .sendKeys(getValue(0 ,3));

        $$(By.className("android.widget.EditText"))
                .find(Condition.text("Вибродиагностика 3"))
                .sendKeys(getValue(0 ,3));

        $$(By.className("android.widget.EditText"))
                .find(Condition.text("Вибродиагностика 4"))
                .sendKeys(getValue(0 ,3));

        $$(By.className("android.widget.EditText"))
                .find(Condition.text("Вибродиагностика 5"))
                .sendKeys(getValue(0 ,3));

        actions.dragAndDropBy(
                $(By.id("com.universalelectric.app:id/textViewQuestionNumber")),
                0,
                -700
        ).perform();

        $$(By.className("android.widget.EditText"))
                .find(Condition.text("Ток 1"))
                .sendKeys(getValue(105, 80));

        $$(By.className("android.widget.EditText"))
                .find(Condition.text("Ток 2"))
                .sendKeys(getValue(105, 80));

        $$(By.className("android.widget.EditText"))
                .find(Condition.text("Ток 3"))
                .sendKeys(getValue(105, 80));

        actions.dragAndDropBy(
                $(By.id("com.universalelectric.app:id/textViewQuestionNumber")),
                0,
                -300
        ).perform();

        $$(By.className("android.widget.EditText"))
                .find(Condition.text("Т-элемента 1"))
                .sendKeys(getValue(29, -50));

        $$(By.className("android.widget.EditText"))
                .find(Condition.text("Т-окр.ср. 1"))
                .sendKeys(getValue(29, -50));

        actions.dragAndDropBy(
                $(By.id("com.universalelectric.app:id/textViewQuestionNumber")),
                0,
                -700
        ).perform();

        $$(By.className("android.widget.EditText"))
                .find(Condition.text("ИБП/ЗУ/ТВУ 1"))
                .sendKeys(getValue(387, 333));

        $$(By.className("android.widget.EditText"))
                .find(Condition.text("ИБП/ЗУ/ТВУ 2"))
                .sendKeys(getValue(387, 333));

        $$(By.className("android.widget.EditText"))
                .find(Condition.text("ИБП/ЗУ/ТВУ 3"))
                .sendKeys(getValue(387, 333));

        $$(By.className("android.widget.EditText"))
                .find(Condition.text("ИБП/ЗУ/ТВУ 4"))
                .sendKeys(getValue(236, 204));

        $$(By.className("android.widget.EditText"))
                .find(Condition.text("ИБП/ЗУ/ТВУ 5"))
                .sendKeys(getValue(236, 204));

        $$(By.className("android.widget.EditText"))
                .find(Condition.text("ИБП/ЗУ/ТВУ 6"))
                .sendKeys(getValue(236, 204));

        actions.dragAndDropBy(
                $(By.id("com.universalelectric.app:id/textViewQuestionNumber")),
                0,
                -700
        ).perform();

        $$(By.className("android.widget.EditText"))
                .find(Condition.text("ЗУ/ТВУ на выходе 1"))
                .sendKeys(getValue(96, 104));

        $$(By.className("android.widget.EditText"))
                .find(Condition.text("ИБП на входе 1"))
                .sendKeys(getValue(187, 253));

        actions.dragAndDropBy(
                $(By.id("com.universalelectric.app:id/textViewQuestionNumber")),
                0,
                -1000
        ).perform();

        $$(By.className("android.widget.EditText"))
                .find(Condition.text("ИБП на выходе 1"))
                .sendKeys(getValue(187, 253));

        $(By.id("com.universalelectric.app:id/buttonComplete")).click();
        $(By.id("com.universalelectric.app:id/profileFragment")).click();
        $(By.id("com.universalelectric.app:id/buttonSync")).click();
    }

    //@Test
    public void test() throws MalformedURLException {

        WebDriverRunner.setWebDriver(init.connectToDevice());

        AndroidDriver driver = (AndroidDriver) WebDriverRunner.getWebDriver();
        Actions actions = new Actions(driver);

        $(By.id("com.universalelectric.app:id/profileFragment")).click();
        $(By.id("com.universalelectric.app:id/buttonSync")).click();
        int i = 0;
    }

}
