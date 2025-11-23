package gettingStarted;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class RefinedLocatorTest {
    public static void main(String[] args) {

        //1.Create a WebDriver with ChromeDriver object
        //2.Launch the browser
        WebDriver driver = new ChromeDriver();

        //3.Navigate to a specific URL
        driver.navigate().to("http://eaapp.somee.com/");

        Login(driver);

        //Create User
        CreateUser(driver);

        Logoff(driver);
    }

    public static void Login(WebDriver driver) {

        //1.Click the login link
        driver.findElement(By.linkText("Login")).click();

        //2.Enter UserName
        driver.findElement(By.name("UserName")).sendKeys("admin");

        //3.Enter Password
        driver.findElement(By.name("Password")).sendKeys("password");

        //Click the login button
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

    public static void Logoff(WebDriver driver) {

        driver.findElement(By.linkText("Log off")).click();
    }
}
