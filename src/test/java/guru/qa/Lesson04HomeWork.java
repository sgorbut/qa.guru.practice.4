package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Lesson04HomeWork {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void textJUnit5() {
        open("https://github.com/selenide/selenide");     // Page url
        $("#wiki-tab").click(); // wiki
        $(".js-wiki-more-pages-link").click();  // Expand list
//        $("#wiki-pages-filter").setValue("SoftAssertions").pressEnter();    // Find by text
        $("#wiki-pages-box").find(byText("SoftAssertions")).click(); // Click by text
//        $("#wiki-body").shouldHave(text("Using JUnit5"));   // assert
        $(".gollum-markdown-content").shouldHave(text("Using JUnit5"));   // assert
    }

    @Test
    void dragAndDrop() {
        open("https://the-internet.herokuapp.com/drag_and_drop");     // page url
        $("#column-a").dragAndDropTo($("#column-b"));   // drag and drop
        $("#column-a").shouldHave(text("B"));   // assert
    }
}