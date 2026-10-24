//import data.Language;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.Arguments;
//import org.junit.jupiter.params.provider.EnumSource;
//import org.junit.jupiter.params.provider.MethodSource;
//
//import java.util.List;
//import java.util.stream.Stream;
//
//import static com.codeborne.selenide.CollectionCondition.texts;
//import static com.codeborne.selenide.Condition.text;
//import static com.codeborne.selenide.Condition.visible;
//import static com.codeborne.selenide.Selenide.*;
//
//public class gcLanguageTest {
//
//    @EnumSource(Language.class)
//    @ParameterizedTest
//    void gcSiteShouldDisplayCorrectText() {
//        open("https://gymkhana-cup.ru/");
//        $(".dropdown.pk-menu-items.flags.open").click();
//        sleep(6000);
//
////        $(".pk-menu-items.dropdown.pk-menu-items.flags.open").click();
////        $$("a.change-language").find(text(language.name())).click();
////        $(".title-with-bg").shouldHave(text(language.description));
//    }
//
//
//    static Stream<Arguments> gsSiteShouldDisplayCorrectButtons() {
//        return Stream.of(
//                Arguments.of(
//                        Language.en_US,
//                        List.of("Information","Competitions", "Riders", "Gymkhana GP", "Login")
//                ),
//                Arguments.of(
//                        Language.ru_RU,
//                        List.of("Инофрмация", "Соревнования", "Спортсмены", "Вход")
//                )
//        );
//    }

//    @MethodSource
//    @ParameterizedTest
//    void gcSiteShouldDisplayCorrectButtons(Language language, List<String> expectedButtons) {
//        open("https://gymkhana-cup.ru/");
//        $$(".change-language").find(text(language.name())).click();
//        $$("#navbarCollapse").filter(visible)
//                .shouldHave(texts(expectedButtons));
//    }
//}

