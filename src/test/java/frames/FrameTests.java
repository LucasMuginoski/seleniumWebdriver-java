package frames;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FrameTests extends BaseTests {

    @Test
    public void testWYSIWYG(){
        var editorPage = homePage.clickEditor();
        editorPage.clearTextArea();

        String text1 = "Hello ";
        String text2 = "world!";

        editorPage.setTextArea(text1);
        editorPage.decreaseIndentButton();
        editorPage.setTextArea(text2);
        assertEquals(editorPage.getTextFromEditor(), text1 + text2, "Text do not match");
    }
}
