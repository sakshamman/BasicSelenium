package gettingStarted;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

    public static void main(String[] args) {
        //creating a webdriver with chrome drive object, launch the browser
        WebDriver driver = new ChromeDriver();

        //navigate to a specific URL
        driver.navigate().to("https://www.bing.com");

        //set the screen as full screen
        driver.manage().window().fullscreen();

        //get the current page source
        String pageSource = driver.getPageSource();

        if (pageSource.contains("Search with Microsoft Bing and use the power of AI to find information")) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }


    }
}
