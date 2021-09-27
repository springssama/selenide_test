package guru.qa;

import com.codeborne.selenide.Configuration;
import guru.qa.page.GithubPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class GithubTest {

    guru.qa.page.GithubPage githubPage = new GithubPage();
    String githubUrl = "https://github.com/";
    String selenideName = "selenide";
    String searchName = "SoftAssertions";

    @BeforeAll
    static void beforeAl() {
        Configuration.startMaximized = true;
    }

    @Test
    void openSoftAssertionPageInGithub() {
        githubPage.openPage(githubUrl);
        githubPage.searchSelenide(selenideName);
        githubPage.searchSortAssertions(searchName);
        githubPage.verifyResults();
    }
}
