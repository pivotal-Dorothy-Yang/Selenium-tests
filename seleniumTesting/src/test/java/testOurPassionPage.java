import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class testOurPassionPage {
    @Before
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "/Users/pivotal/drivers/chromedriver");
    }

    @Test
    public void ourPassionSection_UIElementsAreVisible() {
        WebDriver driver = new ChromeDriver();
        openOurPassionPage(driver);
        WebElement passionTitle = driver.findElement(By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000450914914\"]/div/h1"));
        WebElement passionText1 = driver.findElement(By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000450914902\"]/div/p[2]"));
        WebElement passionText2 = driver.findElement(By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000450914902\"]/div/p[4]"));
        WebElement passionImg = driver.findElement(By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000450914904\"]/div/div/img"));

        String title = driver.findElement(By.id("wsb-element-00000000-0000-0000-0000-000450914914")).getText();
        String text1 = driver.findElement(By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000450914902\"]/div/p[2]")).getText();
        String text2 = driver.findElement(By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000450914902\"]/div/p[4]")).getText();

        Assert.assertTrue(passionTitle.isDisplayed());
        Assert.assertTrue(passionText1.isDisplayed());
        Assert.assertTrue(passionText2.isDisplayed());
        Assert.assertTrue(passionImg.isDisplayed());

        Assert.assertEquals(title, passionTitle.getText());
        Assert.assertEquals(text1, passionText1.getText());
        Assert.assertEquals(text2, passionText2.getText());
    }

    @Test
    public void theExpertsSection_UIElementsAreVisible() {
        WebDriver driver = new ChromeDriver();
        openOurPassionPage(driver);
        WebElement expertsTitle = driver.findElement(By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000450914903\"]/div/h2"));
        WebElement expertsText = driver.findElement(By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000450914920\"]/div/p"));
        WebElement expertsImg = driver.findElement(By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000450914905\"]/div/div/img"));
        WebElement dividingLine = driver.findElement(By.id("wsb-element-00000000-0000-0000-0000-000450914901"));

        String title = driver.findElement(By.id("wsb-element-00000000-0000-0000-0000-000450914903")).getText();
        String text = driver.findElement(By.id("wsb-element-00000000-0000-0000-0000-000450914920")).getText();

        Assert.assertTrue(dividingLine.isDisplayed());
        Assert.assertTrue(expertsTitle.isDisplayed());
        Assert.assertTrue(expertsText.isDisplayed());
        Assert.assertTrue(expertsImg.isDisplayed());

        Assert.assertEquals(title, expertsTitle.getText());
        Assert.assertEquals(text, expertsText.getText());

        driver.close();
        driver.quit();
    }


    public void openOurPassionPage(WebDriver driver) {
        driver.get("http://www.practiceselenium.com/");
        driver.findElement(By.linkText("Our Passion")).click();
    }
}
