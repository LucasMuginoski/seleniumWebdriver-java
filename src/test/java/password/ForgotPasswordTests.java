package password;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ForgotPasswordTests extends BaseTests {

    @Test
    public void testForgotPassword(){
        var forgetPasswordPage = homePage.clickForgotPassword();
        assertEquals(forgetPasswordPage.getForgotPasswordTitle(), "Forgot Password", "Message is incorrect");
        var emailSentPage = forgetPasswordPage.retrivePassword("tauexample@email.com");
        assertEquals(emailSentPage.getMessage(), "Your e-mail's been sent!", "Message is incorrect");
    }

}
