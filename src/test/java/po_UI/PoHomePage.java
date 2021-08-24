package po_UI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.TestBase;

public class PoHomePage extends TestBase {


    public PoHomePage(WebDriver driver) {

        TestBase.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void Navigate_to_URL(String url)
    {
        driver.manage().window().maximize();
        driver.navigate().to(url);
    }


    @FindBy(xpath = "//input[@name='query']")
    WebElement search;

    @FindBy(xpath = "//div/*[@data-qa='searchIcon']")
    WebElement searchIcon;



    public void Search_Location(String location) throws InterruptedException {

        browserUtils.click(search);
        browserUtils.TypeInput(search,location);
        browserUtils.click(searchIcon);
      //  browserUtils.WaitforPageLoad(5);


    }
}
