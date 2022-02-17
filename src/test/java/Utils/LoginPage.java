package Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class LoginPage {

    public WebDriver driver;

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void LaunchBrowser()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Gopal\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    public void OpenURL()
    {
        driver.get("https://www.facebook.com/");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        WebElement cookie = driver.findElement(By.xpath(".//*[@title='Allow All Cookies']"));
        js.executeScript("arguments[0].click()", cookie);

    }
    public void QuitBrowser()
    {
        driver.quit();

    }

    public void Login(String userId_input, String passWord_input) throws InterruptedException {
        WebElement userId = driver.findElement(By.xpath(".//*[@id='email']"));
        WebElement pass = driver.findElement(By.xpath(".//*[@id='pass']"));
        WebElement login = driver.findElement(By.xpath(".//*[@name='login']"));

        userId.sendKeys(userId_input);
        pass.sendKeys(passWord_input);
        login.click();
        Thread.sleep(3000);
    }

    public void Logout() throws InterruptedException {
        WebElement account = driver.findElement(By.xpath(".//*[@aria-label='Account']"));
        account.click();
        Thread.sleep(5000);
        WebElement logout = driver.findElement(By.xpath(".//*[@dir='auto'][text()='Log Out']"));
        logout.click();
    }

    public WebElement Messages(String message)
    {
        String newPath = "//div[text()= '" + message + "']";
        WebElement messageElement = driver.findElement(By.xpath(newPath));
        //String messageOutput = messageElement.getText();
        //Assert.assertEquals(message, messageOutput);
        return messageElement;
    }

    }
