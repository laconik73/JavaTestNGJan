package homeWork;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;


public class OrangeHrm {
    WebDriver driver;


    @BeforeSuite
    public void setup() {

        System.setProperty("webdriver.gecko.driver", "C:\\Users\\sabin\\IdeaProjects\\JavaTestNGJan\\src\\test\\resources\\drivers\\geckodriver.exe");

        driver = new FirefoxDriver();
    }

    @Test
    public void test001() {
        driver.get("http://local.school.portnov.com:9595/symfony/web/index.php/auth/login");
        String parentHandle = driver.getWindowHandle();
        String Username = "admin";
        String Password = "password";

        driver.findElement(By.xpath("//*[@id='txtUsername']")).sendKeys("admin");

        driver.findElement(By.xpath("//*[@id='txtPassword']")).sendKeys("password");

        WebElement clickableElement = driver.findElement(By.xpath("//*[@id='btnLogin']"));
        clickableElement.click();


        }


    @Parameters ({"adminParam", "passwordParam"})

    @Test
    public void test002(String adminParam, String passwordParam){
        driver.get("http://local.school.portnov.com:9595/symfony/web/index.php/auth/login");
        String parentHandle = driver.getWindowHandle();
        String Username = "adminParam";
        String Password = "passwordParam";

        driver.findElement(By.xpath("//*[@id='txtUsername']")).sendKeys("admin");

        driver.findElement(By.xpath("//*[@id='txtPassword']")).sendKeys("password");

        WebElement clickableElement = driver.findElement(By.xpath("//*[@id='btnLogin']"));
        clickableElement.click();


    }

    @Test(dataProvider = "myDataProvider001")
    public void test003(String adminParam, String passwordParam) {
        driver.get("http://local.school.portnov.com:9595/symfony/web/index.php/auth/login");
        String parentHandle = driver.getWindowHandle();
        String Username = "adminParam";
        String Password = "passwordParam";

        driver.findElement(By.xpath("//*[@id='txtUsername']")).sendKeys("admin");

        driver.findElement(By.xpath("//*[@id='txtPassword']")).sendKeys("password");

        WebElement clickableElement = driver.findElement(By.xpath("//*[@id='btnLogin']"));
        clickableElement.click();

    }
    @DataProvider(name = "myDataProvider001")
    public Object[][] createData1() {
        return new Object[][]{
                {"admin", "password"},
                {"admin", "Hello"},
        };
    }
    @AfterSuite
    public void close(){
        driver.close();
    }
}

