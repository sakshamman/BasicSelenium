package gettingStarted;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LocatorTest {
    public static void Login(String[] args) {
        //creating a webdriver with chrome drive object, launch the browser
        WebDriver driver = new ChromeDriver();

        //navigate to a specific URL
        driver.navigate().to("http://www.eaapp.somee.com/");

        //click the login link
        //1.identify the login link using its ID
        By locator = By.id("loginLink");

        //2. pass the locator to the webdriver which can help me do the operations on UI
        WebElement element = driver.findElement(locator);

        //3. perform operation on UI - Click in my case
        element.click();

        By txtUserName = By.name("UserName");
        WebElement txtUserNameElement = driver.findElement(txtUserName);
        txtUserNameElement.sendKeys("admin");

        //driver.findElement(By.linkText("Log In")).click();

        //enter password
        driver.findElement(By.id("Password")).sendKeys("password");

        //click login button
        driver.findElement(By.cssSelector(".btn")).click();
    }

    public static void CreateUser(WebDriver driver) {
        driver.findElement(By.linkText("Employee List")).click();

        driver.findElement(By.linkText("Create New")).click();

        driver.findElement(By.name("Name")).sendKeys("AutoUser1");

        driver.findElement(By.id("DurationWorked")).sendKeys("40");

        Select selectGrade = new Select(driver.findElement(By.id("Grade")));
        selectGrade.selectByVisibleText("Middle");

        driver.findElement(By.name("Email")).sendKeys("AutoUser@gmail.com");

        driver.findElement(By.cssSelector(".btn")).click();

        //if mandatory field error for salary appears, then enter salary

        if(driver.findElement(By.xpath("//span[text()='The Salary field is required.']")).isDisplayed()){
            driver.findElement(By.name("Salary")).sendKeys("10000");
            driver.findElement(By.cssSelector(".btn")).click();
        } else {
            //do nothing
        }


    }
}
