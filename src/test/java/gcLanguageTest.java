import com.codeborne.selenide.Condition;
import data.Language;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class gcLanguageTest {

    @AfterEach
    void afterEach() {
        closeWebDriver();
    }

    @EnumSource(Language.class)
    @ParameterizedTest
    void gcSiteShouldDisplayCorrectText(Language language) {
        open("https://gymkhana-cup.ru/");
        $(".dropdown.pk-menu-items.flags a.dropdown-toggle").click();
        $$(".dropdown-menu").find(text(language.name())).click();
        $(".title-with-bg").shouldHave(text(language.description));
    }

// это работало)) в списке пробел вместо иконки в панельке вставлен пробел, делала на фактическом результате
//    static Stream<Arguments> gcSiteShouldDisplayCorrectButtons() {
//        return Stream.of(
//                Arguments.of(
//                        Language.RU,
//                        List.of("Информация Соревнования Спортсмены Gymkhana GP Вход")
//                ),
//                Arguments.of(
//                        Language.EN,
//                        List.of("INFORMATION COMPETITIONS RIDERS GYMKHANA GP LOG IN")
//                ),
//                Arguments.of(
//                        Language.CN,
//                        List.of("信息 比赛 运动员 GYMKHANA GP 入口")
//                )
//        );
//    }

    static Stream<Arguments> gcSiteShouldDisplayCorrectButtons() {
        return Stream.of(
                Arguments.of(
                        Language.RU,
                        List.of("Информация", "Соревнования", "Спортсмены",  "Gymkhana GP", "Вход")
                ),
                Arguments.of(
                        Language.EN,
                        List.of("INFORMATION", "COMPETITIONS", "RIDERS", "GYMKHANA GP", "LOG IN")
                ),
                Arguments.of(
                        Language.CN,
                        List.of("信息", "比赛", "运动员", "GYMKHANA GP", "入口")
                )
        );
    }

    @MethodSource
    @ParameterizedTest
    void  gcSiteShouldDisplayCorrectButtons (Language language, List<String> expectedButtons) {
        open("https://gymkhana-cup.ru/");
        $(".dropdown.pk-menu-items.flags a.dropdown-toggle").click();
        sleep(2000);

        //   $$(".dropdown-menu").find(text(language.name())).click(); неправильное для себя, для истории
        //        $$(".dropdown-menu a.change-language").find(attribute("data-lang", language.code)).click();

        $$("a.change-language[data-lang='" + language.code + "']") .findBy(visible) .click();


        // со старым локатором тоже работало) потому что вместо кнопки со сменой языка у меня вставлен пробел)))
        //        $$("#navbarCollapse").filter(visible)
//                .shouldHave(texts(expectedButtons));

        $$("#navbarCollapse > ul.nav.navbar-nav.navbar-left > li > a")
                .excludeWith(Condition.empty)
                .shouldHave(texts(expectedButtons));
    }
}
