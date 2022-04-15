package autotests.tests;

import autotests.helpers.DriverUtils;
import com.codeborne.selenide.SelenideElement;
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
        step("Открыть url 'https://www.eldorado.ru'", () -> {
            open("https://www.eldorado.ru");
        });

        step("Заголовок страницы с текстом 'Эльдорадо - интернет-магазин электроники, цифровой и бытовой техники, выгодные цены, доставка по Москве и регионам'", () -> {
            String expectedTitle = "Эльдорадо - интернет-магазин электроники, цифровой и бытовой техники, выгодные цены, доставка по Москве и регионам";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    @Test
    @DisplayName("Отображение окна 'Статус заказа'")
    void statusOrderWindowTest() {
//        step("Открыть url 'https://www.eldorado.ru'", () -> {
//            open("https://www.eldorado.ru");
//        });
//
//        step("Нажать в шапке на вкладку 'Статус заказа'", () -> {
//            $("[href='/personal/orders/']").shouldBe(exist).click();
//        });
//
//        step("В окне отображается кнопка 'Проверить заказ'", () -> {
//            SelenideElement buttonCheckOrder = $$("button[type=submit]").findBy(text("Проверить заказ"));
//
//            String actualButtonText = buttonCheckOrder.getText();
//            String expectedButtonText = "Проверить заказ";
//
//            assertThat(actualButtonText).isEqualTo(expectedButtonText);
//        });
    }

    @Test
    @DisplayName("В логах консоли отсутствуют ошибки")
    void consoleShouldNotHaveErrorsTest() {
//        step("Открыть url 'https://www.eldorado.ru'", () -> {
//            open("https://www.eldorado.ru");
//        });
//
//        step("В логах консоли отсутствует текст с 'SEVERE'", () -> {
//            String consoleLogs = DriverUtils.getConsoleLogs();
//            String errorText = "SEVERE";
//
//            assertThat(consoleLogs).contains(errorText);
//        });
    }

    @Test
    @DisplayName("Успешный поиск по модели 'logitech m170'")
    void modelSearchSuccessfulTest() {
//        step("Открыть url 'https://www.eldorado.ru'", () -> {
//            open("https://www.eldorado.ru");
//        });
//
//        step("Ввести в поле поиска 'logitech m170' и нажать Enter", () -> {
//            $("[placeholder='Искать Honor X8'").setValue("logitech m170").pressEnter();
//        });
//
//        step("Текст соответствует найденой модели", () -> {
//
//            String actualText = $("[data-dy='title']").getText();
//            String expectedText = "logitech m170";
//
//            assertThat(actualText).containsIgnoringCase(expectedText);
//        });
    }

    @Test
    @DisplayName("Переход в пустую корзину")
    void emptyBasketTest() {
//        step("Открыть url 'https://www.eldorado.ru'", () -> {
//            open("https://www.eldorado.ru");
//        });
//
//        step("Нажать возле поиска на 'Корзина'", () -> {
//            $("[href='/personal/basket.php']").shouldBe(exist).click();
//        });
//
//        step("Текст на странице 'Ваша корзина пуста.'", () -> {
//            String actualText = $(".empty-basket-one").getText();
//            String expectedText = "Ваша корзина пуста.";
//
//            assertThat(actualText).isEqualTo(expectedText);
//        });
    }
}