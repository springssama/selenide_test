package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class GithubTest {
    @BeforeAll
    static void beforeAl() {
        Configuration.startMaximized = true;
    }

    @Test
    void openSoftAssertionPageInGithub() {
        open("https://github.com/");
        $(".js-site-search-form").click();
        $("[data-test-selector='nav-search-input']").setValue("selenide").pressEnter();
        $$("ul.repo-list li").first().$("a").click();
        $("[data-content='Wiki']").click();
        $(".js-wiki-more-pages-link").click();
        $(".wiki-rightbar").$(byText("SoftAssertions")).click();
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class:"));
        $(".markdown-body").shouldHave(text("@ExtendWith({SoftAssertsExtension.class})"));
    }
}
