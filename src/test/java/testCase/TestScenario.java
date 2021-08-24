package testCase;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import po_UI.PoAccuWeather_UI;
import po_API.poAccuWeather_API;
import po_UI.PoHomePage;
import utilities.TestBase;

public class TestScenario extends TestBase {



    PoHomePage home;
    PoAccuWeather_UI UI;
    poAccuWeather_API API;


    @BeforeTest
    public void settingUpEnvironment() throws Exception{

        home = new PoHomePage(driver);
        UI = new PoAccuWeather_UI(driver);
        API = new poAccuWeather_API();
        home.Navigate_to_URL(configProps.get_UI_URL());

    }


    @Test()
    public void Compare_Temperature() throws Exception {

        home.Search_Location(data.get_property("UI_Location"));
        int UI_Temp=UI.get_current_Weather();
        int API_Temp=API.get_current_Weather_API();
        System.out.println("The temperature in UI ==== "+UI_Temp+"\nThe temperature in API ==== "+API_Temp);

    }
}
