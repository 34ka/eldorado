package autotests.tests;

import autotests.helpers.DriverUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.*;

@Tag("regress")
public class MainPageTests extends TestBase {

    @Test
    @DisplayName("Главная страница имеет заголовок")
    void titleTest() {
        step("Открыть url 'https://www.sberbank.ru'", () -> {
            open("https://www.sberbank.ru");
            $("[alt='Официальный сайт Сбербанка России']").shouldBe(enabled);
        });

        step("Заголовок страницы с текстом 'СберБанк для физических лиц — банковские услуги — СберБанк'", () -> {
            String expectedTitle = "СберБанк для физических лиц — банковские услуги — СберБанк";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    @Test
    @DisplayName("Смена региона на 'Республика Карелия'")
    void checkChangeRegion(){
        step("Открыть url 'https://www.sberbank.ru'", () -> {
            open("https://www.sberbank.ru");
            $("[alt='Официальный сайт Сбербанка России']").shouldBe(enabled);
        });

        step("Нажать на регион, ввести необходимый регион", () -> {
            $("[data-cga_open_region='desktop']").click();
            $(".kitt-header-region__search").setValue("Карелия").pressEnter();
        });

        step("Регион отображается и соответствует выбранному", () -> {
            String actualRegion = $("[data-cga_open_region='desktop']").getText();
            String expectedRegion = "Республика Карелия";

            assertThat(actualRegion).isEqualTo(expectedRegion);
        });
    }

    @Test
    @DisplayName("В логах консоли отсутствуют ошибки")
    void consoleShouldNotHaveErrorsTest() {
        step("Открыть url 'https://www.sberbank.ru'", () -> {
            open("https://www.sberbank.ru");
            $("[alt='Официальный сайт Сбербанка России']").shouldBe(enabled);
        });

        step("В логах консоли отсутствует текст с 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).contains(errorText);
        });
    }

    @Test
    @DisplayName("Смена языка с русского на английский")
    void changeLanguageEngTest() {
        step("Открыть url 'https://www.sberbank.ru'", () -> {
            open("https://www.sberbank.ru");
            $("[alt='Официальный сайт Сбербанка России']").shouldBe(enabled);
        });

        step("Нажать в шапке на вкладку с текстом 'ENG'", () -> {
            $("[data-cga_change_lang='en']").click();
        });

        step("На странице присутствует текст на английском", () -> {

            String actualText = $(".page-teaser-dict__descr").getText();
            String expectedText = "SberBank is the largest bank in Russia, Central and Eastern Europe, and one of the leading financial institutions worldwide";

            assertThat(actualText).isEqualTo(expectedText);
        });
    }

    @Test
    @DisplayName("Нажать на голосового ассистента")
    void clickOnTheVoiceAssistantTest() {
        step("Открыть url 'https://www.sberbank.ru'", () -> {
            open("https://www.sberbank.ru");
            $("[alt='Официальный сайт Сбербанка России']").shouldBe(enabled);
        });

        step("Нажать на зелёный шар", () -> {
            $("button[class='sc-jSgupP bgJdTa sc-cvJHqN oPtac']").shouldBe(enabled).click();
        });

        step("Во всплывающем окне присутствует приветственный текст", () -> {
            String actualText = $("[data-cy='bubble']").getText();
            String expectedText = "Здравствуйте! Меня зовут Сбер — ваш виртуальный ассистент на сайте банка";

            assertThat(actualText).isEqualTo(expectedText);
        });
    }
}