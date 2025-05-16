package alerts;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AlertsTests extends BaseTests {

    @Test
    public void testClickforJSAlert(){
        var alertsPage = homePage.clickJSAlerts();
        assertEquals(alertsPage.getPageTitle(), "JavaScript Alerts", "Incorrect page title");
        alertsPage.triggerAlert();
        alertsPage.alert_clickToAccept();
        assertEquals(alertsPage.getResult(),
                "You successfully clicked an alert",
                "Something went wrong with accepting the alert");
    }
    @Test
    public void testDismissAlert(){
        var alertsPage = homePage.clickJSAlerts();
        assertEquals(alertsPage.getPageTitle(), "JavaScript Alerts", "Incorrect page title");
        alertsPage.triggerConfirm();
        var text = alertsPage.alert_getText();
        alertsPage.alert_clickToDismiss();
        assertEquals(text, "I am a JS Confirm", "Alert text incorrect");
        assertEquals(alertsPage.getResult(), "You clicked: Cancel");
    }
    @Test
    public void testPrompt(){
        var alertsPage = homePage.clickJSAlerts();
        assertEquals(alertsPage.getPageTitle(), "JavaScript Alerts", "Incorrect page title");
        alertsPage.triggerPrompt();
        var text = "TAU rocks!";
        alertsPage.alert_setInput(text);
        alertsPage.alert_clickToAccept();
        assertEquals(alertsPage.getResult(), "You entered: " + text, "Incorrect message");
    }

}
