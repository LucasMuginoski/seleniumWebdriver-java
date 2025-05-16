package sliders;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class HorizontalSliderTests extends BaseTests {

    @Test
    public void testHorizontalSliderWholeNumber(){
        String value = "4";
        var horizontalSlider = homePage.clickHorizontalSlider();
        assertEquals(horizontalSlider.getTitle(), "Horizontal Slider", "Invalid page title");
        horizontalSlider.setSliderValue(value);
        assertEquals(horizontalSlider.getSliderValue(), value, "Slider value incorrect");
    }
    /*
    @Test
    public void testHorizontalSliderDecimalNumber(){
        String value = "3.5";
        var horizontalSlider = homePage.clickHorizontalSlider();
        assertEquals(horizontalSlider.getTitle(), "Horizontal Slider", "Invalid page title");
        horizontalSlider.setSliderValue(value);
        assertEquals(horizontalSlider.getSliderValue(), value, "Slider value incorrect");
    }
    */
    
}
