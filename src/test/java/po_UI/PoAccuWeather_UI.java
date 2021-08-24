package po_UI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.TestBase;

public class PoAccuWeather_UI extends TestBase {


    public PoAccuWeather_UI(WebDriver driver) {

        TestBase.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "(//div[@class='temp'])[1]")
    WebElement current_Weather;

    @FindBy(xpath = "(//div[@class='temp'])[2]")
    WebElement tonight_Weather;

    @FindBy(xpath = "(//div[@class='temp'])[3]")
    WebElement tomorrow_Weather;

    public int get_current_Weather()
    {
       return Integer.parseInt((current_Weather.getText().split("°C"))[0]);
    }







}
