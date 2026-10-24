import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.time.Duration;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class WebTests {

    @BeforeEach
    void setUp() {
        Configuration.browserSize = "1920x1080";
    }

    @AfterEach
    void afterEach() {
        closeWebDriver();
    }

    @ParameterizedTest(name = "Тест 1: Открытие {0} и проверка элемента {1}")
    @DisplayName("Открытие веб-страниц")
    @CsvSource({
            "https://www.blizzard.com/ru-ru/games, h2.blz-heading-xl",
            "https://demoqa.com, .banner-image",
            "https://qa.guru, .elementor-heading-title"
    })
    void testWithCsvSource(String url, String selector) {
        open(url);
        var element = $(selector);
        element.shouldBe(com.codeborne.selenide.Condition.exist);

        System.out.println("Страница открыта: " + url + " | Элемент найден: " + selector);
    }

    @ParameterizedTest(name = "набор ТД {3}")
    @CsvFileSource(resources = "/test_data/registrationRequiredFieldsSucess.csv")
    @DisplayName("Регистрация с разными тестовыми данными с обязательными полями")
    void registrationRequiredFieldsSuccess(String firstName, String lastName, String userEmail, String gender, String userNumber){
    open("https://demoqa.com/automation-practice-form");

    $("#firstName").setValue(firstName);
    $("#lastName").setValue(lastName);
    $("#userEmail").setValue(userEmail);
    $("#genterWrapper").$(byText(gender)).click();
    $("#userNumber").setValue(userNumber);

    $("#submit").scrollTo().click();
    //sleep(6000); это для меня, не ругайтесь пожалуйста

    $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text(firstName+" "+lastName));
    $(".table-responsive").$(byText("Gender")).parent().shouldHave(text(gender));
    $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text(userNumber));
    $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text(userEmail));
    }

    //@ParameterizedTest(name = "набор кнопок")
    //@CsvFileSource(resources = "/test_data/registrationRequiredFieldsSucess.csv")
//    @DisplayName("Проверка наличия кнопок на разных языках страницы")
//    @Test
//    void checkButtonsDifferentLanguage() {
//        open("https://www.susu.ru/");
//        sleep(6000);
//    }

}