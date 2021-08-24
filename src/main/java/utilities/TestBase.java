package utilities;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    public static BrowserUtilities browserUtils;
    public static RestUtilities rest;
    public static ConfigFileReader configProps;
    public static ConfigFileReader data;
    public static ConfigFileReader endpoint;
    public static WebDriver driver;



    @BeforeSuite
    public void triggerDependency()
    {
        //Initializing browser Utilities package
        browserUtils = new BrowserUtilities();
        //Initializing rest utilities package
        rest = new RestUtilities();
        //Loading the config file
        configProps = new ConfigFileReader("config.properties");
        //Loading the Test data file
        data = new ConfigFileReader("TestData.properties");
        //Loading the Endpoints file
        endpoint= new ConfigFileReader("Endpoint.properties");
        //Launching the browser based on the value from the config file
        browserUtils.LaunchBrowser(configProps.getBrowser());



    }

    @AfterSuite
    public void shutdown()
    {
        driver.quit();
    }
}
