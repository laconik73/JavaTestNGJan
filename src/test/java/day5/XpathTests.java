package day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class XpathTests<driver> {


    WebDriver driver;
    By textEditorInput = By.id("tinymce");



    @BeforeSuite
    public void setup() {

        System.setProperty("webdriver.gecko.driver", "C:\\Users\\sabin\\IdeaProjects\\JavaTestNGJan\\src\\test\\resources\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();


    }

    @Test
    public void test001() {
        String xpath = "html/body/div[1]/div[2]/div[2]/div[1]/form/div[1]/div/div[1]/div/div/input[1]";
        String xpath2 ="//form/div[1]/div/div[1]/div/div/input[1]";
        String xpath3 = "//*[@name='restaurant_id']";
        String xpath4 = "//*[@name='restaurant_id'][@type= 'text']";
        String xpath5 = "//*[@name='restaurant_id' and @type= 'text']";
        String xpath6 = "//*[@name='restaurant_id' or @type= 'fjalfajlfa']";
        String xpath7 = "//*[contains(@name,'taurant_id')]";
        String xpath8= "//*[starts-with(@name,'rest')]";
        String xpath9= "//*[text()='Log In']";
        String xpath10 = "(//input[@type='text'])[last()]";
        String xpath11= "//input[@type='text'])[2]";
        String xpath12= "//input[@type='text'])[position()=2]";
        String xpath13= "//*[@id='FirstName']/following::input[@type='text']";
        String xpath14= "//*[@id='LastName']//preceding::input[@type='text']";

    }


    @AfterSuite
   public void close(){
        driver.close();
    }


    //TO DO:  why we found email input using following locator
    //TO DO: find email input for position () xpath method




    @BeforeTest
    public void setDriver() {
    }


    @Test
    public void Facebook() {
        driver.get("https://www.facebook.com/");
        driver.findElement(By.xpath("(//input[@type='text'])[last()]")).sendKeys("hello");


    }

    @Test
    public void testPosition() {
        driver.get("https://www.facebook.com/");
        driver.findElements(By.xpath("(*[@type='radio'])[position()=1]"));
    }

    @AfterTest
    public void quit(){
        driver.quit();
    }

    }



