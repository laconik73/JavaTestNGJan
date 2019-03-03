package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java.util.Set;

import static org.testng.Assert.assertTrue;


public class WindowHandles<url> {
    WebDriver driver;


    @BeforeSuite
    public void setup() {

        System.setProperty("webdriver.gecko.driver", "C:\\Users\\sabin\\IdeaProjects\\JavaTestNGJan\\src\\test\\resources\\drivers\\geckodriver.exe");

        driver = new FirefoxDriver();
    }

    @Test
    public void test001() {
        String url = "http://the-internet.herokuapp.com/windows";

        openMainPage(url);
        clickOnLink("Click Here");
        mySleep(2);
        assertTwoWindows();
        switchToNewWindow();
        assertTextOnPage();

    }

    private void assertTextOnPage() {
        Assert.assertTrue(driver.getPageSource().contains("New Window"));

    }

    private void switchToNewWindow() {
        Object[] array = driver.getWindowHandles().toArray();
        String windowHandle1 = (String) array[1];
        driver.switchTo().window(windowHandle1);
        String actualWindowTitle = driver.getTitle();
        String expectedWindowTitle = "New Window";
        Assert.assertEquals(actualWindowTitle, expectedWindowTitle);

    }

    private void mySleep(int timeInSeconds) {

        try {
            Thread.sleep(timeInSeconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void assertTwoWindows() {
        Set<String> windowHandles = driver.getWindowHandles();
        int size = windowHandles.size();
        int expectedSize = 2;

        Assert.assertEquals(size, expectedSize);
        Object[] array = windowHandles.toArray();
        String windowHandle1 = (String) array[1];


    }

    private void clickOnLink(String linkText) {
        WebElement element = driver.findElement(By.partialLinkText(linkText));
        element.click();

    }

    private void openMainPage(String url) {
        driver.get(url);

    }

    @Test
    public void testHW() {
        //make a different scenario with WindowHandles
        //To Do: create an explicit wait here


        String url = "http://the-internet.herokuapp.com/windows";
        driver.get(url);
        openMainPage(url);
        waitForResultPage();
        assertResultPage();
    }

    private void assertResultPage() {
        WebElement resultStats = driver.findElement(By.id("New Window"));
        boolean isResultsDisplayed = resultStats.isDisplayed();
        assertTrue(isResultsDisplayed);
    }

    private void waitForResultPage() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("New Window")));

    }
}