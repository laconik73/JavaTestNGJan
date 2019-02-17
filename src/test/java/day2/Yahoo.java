package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


public class Yahoo {
    RemoteWebDriver driver;



    public void setup() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sabin\\IdeaProjects\\JavaTestNGJan\\src\\test\\resources\\drivers\\chromedriver.exe");

        driver = new ChromeDriver();

    }

    @Test
    public void test001() {
        String property = System.setProperty("webdriver.chrome.driver", "C:\\Users\\sabin\\IdeaProjects\\JavaTestNGJan\\src\\test\\resources\\drivers\\chromedriver.exe");

    }

    @Test
    public void testYahooSearch() {
        String queryString = "portnov computer school";
    openMainPage();
    typeQuery(queryString);
    submitSearch();
    waitForResultPage ();
    assertResultPage();

}

    private void waitForResultPage() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("resultStats")));

    }

    private void assertResultPage() {
        WebElement resultStats =  driver.findElement(By.id("resultStats"));
        boolean isResultsDisplayed = resultStats.isDisplayed();
        assertTrue(isResultsDisplayed);


    }

    private void submitSearch() {
        WebElement inputTextField = driver.findElement(By.cssSelector(".gLFyf"));
        inputTextField.submit();
    }

    private void typeQuery(String textToType) {

        WebElement inputTextField  =  driver.findElement(By.cssSelector(".gLFyf"));
        inputTextField.sendKeys(textToType);
    }

    private void setupBrowser() {

    }


    private void openMainPage() {
        String url = "https://www.google.com";
        driver.get(url);

    }
}

























