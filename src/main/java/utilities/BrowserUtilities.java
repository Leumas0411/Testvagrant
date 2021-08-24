package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class BrowserUtilities extends TestBase{


    public void LaunchBrowser(String browser)
    {
        if(browser.contains("ch"))
        {
            WebDriverManager.chromedriver().setup();
            HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
            chromePrefs.put("profile.default_content_settings.popups", 0);
            chromePrefs.put("download.default_directory", System.getProperty("java.io.tmpdir"));
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--disable-notifications");
            chromeOptions.setExperimentalOption("prefs", chromePrefs);

            driver = new ChromeDriver(chromeOptions);


        }else if(browser.contains("ff"))
        {

            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        }else if(browser.contains("ie"))
        {

            WebDriverManager.edgedriver().setup();
            driver = new InternetExplorerDriver();
        }
    }


    public void click(WebElement ele)
    {
        ele.click();
    }

    public void TypeInput(WebElement ele, String str)
    {
        ele.sendKeys(str);
    }



    public void WaitforPageLoad(int timeoutInSeconds) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        if (js.executeScript("return document.readyState").toString().equals("complete")) {
            return;
        }

        // This loop will rotate for n times mentioned to check If page Is ready after every 1
        // second.

        for (int i = 0; i < timeoutInSeconds; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            // To check page ready state.
            if (js.executeScript("return document.readyState").toString().equals("complete")) {
                break;
            }
        }
    }
}
