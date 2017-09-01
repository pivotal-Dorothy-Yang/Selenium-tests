import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class testMenuPage {
    @Before
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "/Users/pivotal/drivers/chromedriver");
    }

    @Test
    public void testWhenMenuIsTapped_GreenTeaUIElementsAreVisible() {
        WebDriver driver = new ChromeDriver();
        openMenuPage(driver);
        WebElement menuHeading = driver.findElement(By.id("wsb-element-00000000-0000-0000-0000-000450914921"));
        WebElement greenTeaTitle = driver.findElement(By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000453230000\"]/div/p"));
        WebElement greenTeaText = driver.findElement(By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000451934628\"]/div/pre/span"));
        WebElement greenTeaImg = driver.findElement(By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000451933201\"]/div/div/img"));

        String title = driver.findElement(By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000453230000\"]/div/p")).getText();
        String text = driver.findElement(By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000451934628\"]/div/pre/span")).getText();

        Assert.assertTrue(menuHeading.isDisplayed());
        Assert.assertTrue(greenTeaTitle.isDisplayed());
        Assert.assertTrue(greenTeaText.isDisplayed());
        Assert.assertTrue(greenTeaImg.isDisplayed());

        Assert.assertEquals(title, greenTeaTitle.getText());
        Assert.assertEquals(text, greenTeaText.getText());

        driver.close();
        driver.quit();
    }

    @Test
    public void testWhenMenuIsTapped_RedTeaUIElementsAreVisible() {
        WebDriver driver = new ChromeDriver();
        openMenuPage(driver);
        WebElement menuHeading = driver.findElement(By.id("wsb-element-00000000-0000-0000-0000-000450914921"));
        WebElement redTeaTitle = driver.findElement(By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000453231072\"]/div/p"));
        WebElement redTeaText = driver.findElement(By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000451941184\"]/div/pre/span[1]"));
        WebElement redTeaImg = driver.findElement(By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000451938003\"]/div/div/img"));

        String title = driver.findElement(By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000453231072\"]/div/p")).getText();
        String text = driver.findElement(By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000451941184\"]/div/pre/span[1]")).getText();

        Assert.assertTrue(menuHeading.isDisplayed());
        Assert.assertTrue(redTeaTitle.isDisplayed());
        Assert.assertTrue(redTeaText.isDisplayed());
        Assert.assertTrue(redTeaImg.isDisplayed());

        Assert.assertEquals(title, redTeaTitle.getText());
        Assert.assertEquals(text, redTeaText.getText());

        driver.close();
        driver.quit();
    }

    @Test
    public void testWhenMenuIsTapped_OolongTeaUIElementsAreVisible() {
        WebDriver driver = new ChromeDriver();
        openMenuPage(driver);
        WebElement menuHeading = driver.findElement(By.id("wsb-element-00000000-0000-0000-0000-000450914921"));
        WebElement oolongTeaTitle = driver.findElement(By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000453231735\"]/div/p"));
        WebElement oolongTeaText = driver.findElement(By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000451944022\"]/div/pre/span"));
        WebElement oolongTeaImg = driver.findElement(By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000451942740\"]/div/div/img"));

        String title = driver.findElement(By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000453231735\"]/div/p")).getText();
        String text = driver.findElement(By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000451944022\"]/div/pre/span")).getText();

        Assert.assertTrue(menuHeading.isDisplayed());
        Assert.assertTrue(oolongTeaTitle.isDisplayed());
        Assert.assertTrue(oolongTeaText.isDisplayed());
        Assert.assertTrue(oolongTeaImg.isDisplayed());

        Assert.assertEquals(title, oolongTeaTitle.getText());
        Assert.assertEquals(text, oolongTeaText.getText());

        driver.close();
        driver.quit();
    }

    @Test
    public void testCheckOutButtons_HaveCorrectLink() {
        WebDriver driver = new ChromeDriver();
        openMenuPage(driver);
        WebElement greenCheckOut = driver.findElement(By.id("wsb-button-00000000-0000-0000-0000-000451959280"));
        WebElement redCheckOut = driver.findElement(By.id("wsb-button-00000000-0000-0000-0000-000451959280"));
        WebElement oolongCheckOut = driver.findElement(By.id("wsb-button-00000000-0000-0000-0000-000451961556"));

        String expectedURL = "http://www.practiceselenium.com/check-out.html";

        Assert.assertEquals(expectedURL, greenCheckOut.getAttribute("href"));
        Assert.assertEquals(expectedURL, redCheckOut.getAttribute("href"));
        Assert.assertEquals(expectedURL, oolongCheckOut.getAttribute("href"));

        driver.close();
        driver.quit();
    }

    @Test
    public void testTappingCheckOutButtons_opensCheckOutPage() {
        WebDriver driver = new ChromeDriver();
        openMenuPage(driver);
        WebElement greenCheckOut = driver.findElement(By.id("wsb-button-00000000-0000-0000-0000-000451959280"));

        greenCheckOut.click();

        WebElement checkOutTitle1 = driver.findElement(By.id("wsb-element-00000000-0000-0000-0000-000451989411"));

        Assert.assertEquals("Pay with Credit Card or Log In", checkOutTitle1.getText());
        driver.navigate().back();

        WebElement redCheckOut = driver.findElement(By.id("wsb-button-00000000-0000-0000-0000-000451959280"));
        redCheckOut.click();
        WebElement checkOutTitle2 = driver.findElement(By.id("wsb-element-00000000-0000-0000-0000-000451989411"));
        Assert.assertEquals("Pay with Credit Card or Log In", checkOutTitle2.getText());
        driver.navigate().back();

        WebElement oolongCheckOut = driver.findElement(By.id("wsb-button-00000000-0000-0000-0000-000451961556"));
        oolongCheckOut.click();
        WebElement checkOutTitle3 = driver.findElement(By.id("wsb-element-00000000-0000-0000-0000-000451989411"));
        Assert.assertEquals("Pay with Credit Card or Log In", checkOutTitle3.getText());
        driver.navigate().back();

        driver.close();
        driver.quit();
    }

    public void openMenuPage(WebDriver driver) {
        driver.get("http://www.practiceselenium.com/");
        driver.findElement(By.linkText("Menu")).click();
    }
}
