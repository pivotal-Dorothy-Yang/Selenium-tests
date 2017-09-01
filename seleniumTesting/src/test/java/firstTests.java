import org.apache.xpath.SourceTree;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//firefox throws error when using driver.quit()

public class firstTests {
    @Before
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "/Users/pivotal/drivers/chromedriver");
    }

    @Test
    public void testLaunchAndCloseSingleBrowser() {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://google.com");
        driver.close();
        driver.quit();
    }

    @Test
    public void testElementsVisibleOnGooglePage() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.ca");

        WebElement GoogleIcon = driver.findElement(By.id("hplogo"));
        GoogleIcon.isDisplayed();

        //different methods of accessing the same element (speaker icon)
        //using id
        WebElement speakerIcon1 = driver.findElement(By.id("gsri_ok0"));
        //using xpath
        WebElement speakerIcon2 = driver.findElement(By.xpath("//*[@id=\"hplogo\"]"));
        //using css selector
        WebElement speakerIcon3 = driver.findElement(By.cssSelector("#hplogo"));

        WebElement googleSearchIcon = driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[3]/center/input[1]"));
        WebElement luckyIcon = driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[3]/center/input[2]"));
        WebElement googleInFrenchIcon = driver.findElement(By.xpath("//*[@id=\"_eEe\"]"));

//        also valid ways to assert that an element is visible
//        Assert.assertEquals(true, GoogleIcon.isDisplayed());
//        Assert.assertEquals(true, speakerIcon1.isDisplayed());
//        Assert.assertEquals(true, speakerIcon2.isDisplayed());
//        Assert.assertEquals(true, speakerIcon3.isDisplayed());
//        Assert.assertEquals(true, googleSearchIcon.isDisplayed());
//        Assert.assertEquals(true, luckyIcon.isDisplayed());
//        Assert.assertEquals(true, googleInFrenchIcon.isDisplayed());

        Assert.assertTrue(GoogleIcon.isDisplayed());
        Assert.assertTrue(speakerIcon1.isDisplayed());
        Assert.assertTrue(speakerIcon2.isDisplayed());
        Assert.assertTrue(speakerIcon3.isDisplayed());
        Assert.assertTrue(googleSearchIcon.isDisplayed());
        Assert.assertTrue(luckyIcon.isDisplayed());
        Assert.assertTrue(googleInFrenchIcon.isDisplayed());

        driver.close();
        driver.quit();
    }
    @Test
    public void testMakeASearchAndSelectTheFirstLink() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.ca");
        WebElement searchField = driver.findElement(By.id("lst-ib"));
        searchField.sendKeys("pivotal");
        searchField.submit();
        WebElement pivotalHomeLink = driver.findElement(By.linkText("Pivotal: Home"));
        pivotalHomeLink.isDisplayed();
        pivotalHomeLink.click();
        driver.navigate().back();

        driver.close();
        driver.quit();


    }
}
