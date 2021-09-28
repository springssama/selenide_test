package guru.qa.page;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class GithubPage {
    public GithubPage openPage(String url) {
        open(url);
        return this;
    }

    public GithubPage searchSelenide(String value) {
        $(".js-site-search-form").click();
        $("[data-test-selector='nav-search-input']").setValue(value).pressEnter();
        $$("ul.repo-list li").first().$("a").click();
        return this;
    }

    public GithubPage searchSortAssertions(String value) {
        $("[data-content='Wiki']").click();
        $(".js-wiki-more-pages-link").click();
        $(".wiki-rightbar").$(byText(value)).click();
        return this;
    }

    public GithubPage verifyResults() {
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class:"));
        $(".markdown-body").shouldHave(text("@ExtendWith({SoftAssertsExtension.class})"));
        return this;
    }
}
