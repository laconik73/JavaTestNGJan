package day2;

import bsh.This;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class Day2 {


    private FirefoxDriver driver;
    private This textToType;

    @BeforeSuite
    public void setup() {

        System.setProperty("webdriver.gecko.driver", "C:\\Users\\sabin\\IdeaProjects\\JavaTestNGJan\\src\\test\\resources\\drivers\\geckodriver.exe");

        driver = new FirefoxDriver();

    }

    @Test
    public void test001() {


        System.setProperty("webdriver.gecko.driver", "C:\\Users\\sabin\\IdeaProjects\\JavaTestNGJan\\src\\test\\resources\\drivers\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();


    }

    @Test
    public void testGoogleSearch() {
        String queryString = "portnov computer school";

        openMainPage();
        typeQuery(queryString);
        submitSearch();
        waitForResultPage();
        assertResultPage();

    }

    private void waitForResultPage() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("resultStats")));

    }

    private void assertResultPage() {
        WebElement resultStats = driver.findElement(By.id("resultStats"));
        boolean isResultsDisplayed = resultStats.isDisplayed();
        assertTrue(isResultsDisplayed);


    }

    private void submitSearch() {
        WebElement inputTextField = driver.findElement(By.cssSelector(".gLFyf"));
        inputTextField.submit();
    }

    private void typeQuery(String textToType) {

        WebElement inputTextField = driver.findElement(By.cssSelector(".gLFyf"));
        inputTextField.sendKeys(textToType);
    }

    private void setupBrowser() {

    }


    private void openMainPage() {
        String url = "https://www.google.com";
        driver.get(url);

    }

    @Test
    public void testYahooSearch() {

    }

    String textString = "portnov computer school";


    //openYahoo();
    //typeText(String);
    //clickSearch();
    // waitForWrapPage();
    //assertWrapPage();

    private void openYahoo() {
        String url = "https://www.yahoo.com/";
        driver.get(url);

    }

    private void typeText(String textToType) {

        WebElement inputTextField = driver.findElement(By.cssSelector("#uh-search-box"));
        inputTextField.sendKeys(textToType);

    }


    private void clickSearch() {
        WebElement inputTextField = driver.findElement(By.cssSelector("#uh-search-box"));
        inputTextField.click();
    }

    private void assertWrapPage() {
        WebElement resultStats = driver.findElement(By.id("#sbq-wrap"));
        boolean isResultsDisplayed = resultStats.isDisplayed();
        assertTrue(isResultsDisplayed);


    }

    private void waitForWrapPage() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("#sbq-wrap")));


    }
}






