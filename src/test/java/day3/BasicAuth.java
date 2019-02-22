package day3;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.atomic.AtomicReference;

public class BasicAuth<url2, baseUrl> {

    WebDriver driver;


    @BeforeSuite
    public void setup() {

        System.setProperty("webdriver.gecko.driver", "C:\\Users\\sabin\\IdeaProjects\\JavaTestNGJan\\src\\test\\resources\\drivers\\geckodriver.exe");

        driver = new FirefoxDriver();


    }

    @Test
    public void test001() {
        String url = "the-internet.herokuapp.com/basic_auth";

        String login = "admin";
        String password = "admin";


        String url2 = "https://" + login + ":" + password + "@" + url;


        driver.get(url2);

        boolean isCongratsInSource = driver.getPageSource(). contains("Congratulations!");
        Assert.assertTrue(isCongratsInSource);


    }

    }























