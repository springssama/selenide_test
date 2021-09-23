package guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DragAndDropTest {
    @BeforeAll
    static void beforeAl() {
        Configuration.startMaximized = true;
    }

    @Test
    void dragAndDropSquare(){
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").dragAndDropTo("#column-b");
        $("#column-a").shouldHave(Condition.text("B"));
        $("#column-b").shouldHave(Condition.text("A"));
    }
}
