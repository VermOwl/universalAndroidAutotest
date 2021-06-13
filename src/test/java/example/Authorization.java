package example;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import example.system.Initialization;
import io.appium.java_client.android.AndroidElement;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import org.openqa.selenium.interactions.Actions;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Authorization {

    Initialization init = new Initialization();

    public String getValue(int max, int min){
        double random_double = Math.random() * (max - min + 1) + min;
        String test = String.format("%.2f", random_double);
        String final_value = test.replace(',','.');
        return final_value;
    }


    public void createDefect() throws MalformedURLException{

        $$(By.id("com.universalelectric.app:id/textViewHasDefect"))
                .find(Condition.text("Есть дефект"))
                .click();
        $(By.id("com.universalelectric.app:id/radioGroupDefectCauses")).click();
        $(By.id("com.universalelectric.app:id/buttonContinue")).click();
        $(By.id("com.universalelectric.app:id/editTextComment")).sendKeys("Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. ");
        $(By.id("com.universalelectric.app:id/buttonAttachPhoto")).click();
        $(By.id("com.universalelectric.app:id/buttonMakePhoto")).click();
        $(By.id("com.android.camera2:id/shutter_button")).click();
        $(By.id("com.android.camera2:id/done_button")).click();
        $(By.id("com.universalelectric.app:id/buttonSaveAndComplete")).click();
        $(By.id("com.universalelectric.app:id/buttonConfirm")).click();
    }

    @Test
    public void testALoginForm() throws MalformedURLException {

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

        WebDriverRunner.closeWebDriver();
    }

    @Test
    public void testBFirstEquipment() throws MalformedURLException{

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
                .sendKeys(getValue(104, 80));

        $$(By.className("android.widget.EditText"))
                .find(Condition.text("Ток 2"))
                .sendKeys(getValue(104, 80));

        $$(By.className("android.widget.EditText"))
                .find(Condition.text("Ток 3"))
                .sendKeys(getValue(104, 80));

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
//        $(By.id("com.universalelectric.app:id/profileFragment")).click();
//        $(By.id("com.universalelectric.app:id/buttonSync")).click();

        WebDriverRunner.closeWebDriver();
    }

    @Test
    public void testCSecondEquipment() throws MalformedURLException{

        WebDriverRunner.setWebDriver(init.connectToDeviceWithCamera());

        AndroidDriver driver = (AndroidDriver) WebDriverRunner.getWebDriver();
        Actions actions = new Actions(driver);

        $$(By.id("com.universalelectric.app:id/textViewTabSubtitle"))
                .find(Condition.text(("Не проверено")))
                .click();

        actions.clickAndHold($$(By.id("com.universalelectric.app:id/buttonBypass"))
                .find(Condition.text("Начать обход"))).perform();

        actions.dragAndDropBy(
                $(By.id("com.universalelectric.app:id/textViewQuestionNumber")),
                0,
                -500
        ).perform();


        $$(By.className("android.widget.EditText"))
                .find(Condition.text("Вибродиагностика 1"))
                .sendKeys(getValue(6, 10));

        $$(By.className("android.widget.EditText"))
                .find(Condition.text("Вибродиагностика 2"))
                .sendKeys(getValue(6, 10));

        $$(By.className("android.widget.EditText"))
                .find(Condition.text("Вибродиагностика 3"))
                .sendKeys(getValue(6, 10));

        $$(By.className("android.widget.EditText"))
                .find(Condition.text("Вибродиагностика 4"))
                .sendKeys(getValue(6, 10));

        $$(By.className("android.widget.EditText"))
                .find(Condition.text("Вибродиагностика 5"))
                .sendKeys(getValue(6, 10));

        createDefect();

        actions.dragAndDropBy(
                $(By.id("com.universalelectric.app:id/textViewQuestionNumber")),
                0,
                -200
        ).perform();

        $$(By.className("android.widget.EditText"))
                .find(Condition.text("Стробоскоп 1"))
                .sendKeys(getValue(3000, 7000));

        actions.dragAndDropBy(
                $(By.id("com.universalelectric.app:id/textViewQuestionNumber")),
                0,
                -600
        ).perform();

        $$(By.className("android.widget.EditText"))
                .find(Condition.text("Ток 1"))
                .sendKeys(getValue(250, 105));

        $$(By.className("android.widget.EditText"))
                .find(Condition.text("Ток 2"))
                .sendKeys(getValue(250, 105));

        $$(By.className("android.widget.EditText"))
                .find(Condition.text("Ток 3"))
                .sendKeys(getValue(250, 105));

        createDefect();

        actions.dragAndDropBy(
                $(By.id("com.universalelectric.app:id/textViewQuestionNumber")),
                0,
                -500
        ).perform();

        $$(By.className("android.widget.EditText"))
                .find(Condition.text("Т-элемента 1"))
                .sendKeys(getValue(120, 50));

        createDefect();

        $$(By.className("android.widget.EditText"))
                .find(Condition.text("Т-окр.ср. 1"))
                .sendKeys(getValue(120, 50));

        createDefect();

        actions.dragAndDropBy(
                $(By.id("com.universalelectric.app:id/textViewQuestionNumber")),
                0,
                -600
        ).perform();

        $$(By.className("android.widget.EditText"))
                .find(Condition.text("ИБП/ЗУ/ТВУ 1"))
                .sendKeys(getValue(323, 250));

        $$(By.className("android.widget.EditText"))
                .find(Condition.text("ИБП/ЗУ/ТВУ 2"))
                .sendKeys(getValue(500, 437));

        $$(By.className("android.widget.EditText"))
                .find(Condition.text("ИБП/ЗУ/ТВУ 3"))
                .sendKeys(getValue(500, 437));

        $$(By.className("android.widget.EditText"))
                .find(Condition.text("ИБП/ЗУ/ТВУ 4"))
                .sendKeys(getValue(187, 140));

        $$(By.className("android.widget.EditText"))
                .find(Condition.text("ИБП/ЗУ/ТВУ 5"))
                .sendKeys(getValue(187, 140));

        $$(By.className("android.widget.EditText"))
                .find(Condition.text("ИБП/ЗУ/ТВУ 6"))
                .sendKeys(getValue(300, 253));

        createDefect();

        actions.dragAndDropBy(
                $(By.id("com.universalelectric.app:id/textViewQuestionNumber")),
                0,
                -700
        ).perform();

        $$(By.className("android.widget.EditText"))
                .find(Condition.text("ЗУ/ТВУ на выходе 1"))
                .sendKeys(getValue(150, 106));

        createDefect();

        $$(By.className("android.widget.EditText"))
                .find(Condition.text("ИБП на входе 1"))
                .sendKeys(getValue(350, 253));

        createDefect();

        actions.dragAndDropBy(
                $(By.id("com.universalelectric.app:id/textViewQuestionNumber")),
                0,
                -1000
        ).perform();

        $$(By.className("android.widget.EditText"))
                .find(Condition.text("ИБП на выходе 1"))
                .sendKeys(getValue(350, 253));

        createDefect();

        $(By.id("com.universalelectric.app:id/buttonComplete")).click();
//        $(By.id("com.universalelectric.app:id/profileFragment")).click();
//        $(By.id("com.universalelectric.app:id/buttonSync")).click();

        WebDriverRunner.closeWebDriver();
    }

    @Test
    public void testYSync() throws MalformedURLException {

        WebDriverRunner.setWebDriver(init.connectToDevice());

        AndroidDriver driver = (AndroidDriver) WebDriverRunner.getWebDriver();
        Actions actions = new Actions(driver);

        $(By.id("com.universalelectric.app:id/profileFragment")).click();
        $(By.id("com.universalelectric.app:id/buttonSync")).click();

        WebDriverRunner.closeWebDriver();
    }


}
