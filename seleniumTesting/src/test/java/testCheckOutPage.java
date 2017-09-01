import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class testCheckOutPage {
    @Before
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "/Users/pivotal/drivers/chromedriver");
    }

    @Test
    public void testOnLaunch_AllUIElementsAreVisible() {
        WebDriver driver = new ChromeDriver();
        openCheckOutPage(driver);

        WebElement title = driver.findElement(By.id("wsb-element-00000000-0000-0000-0000-000451989411"));
        WebElement description = driver.findElement(By.id("wsb-element-00000000-0000-0000-0000-000451990420"));
        WebElement customerInfo = driver.findElement(By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000452010925\"]/div/div/form/fieldset[1]/legend"));
        WebElement email = driver.findElement(By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000452010925\"]/div/div/form/fieldset[1]/div[1]/label"));
        WebElement name = driver.findElement(By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000452010925\"]/div/div/form/fieldset[1]/div[2]/label"));
        WebElement address = driver.findElement(By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000452010925\"]/div/div/form/fieldset[1]/div[3]/label"));

        WebElement payment = driver.findElement(By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000452010925\"]/div/div/form/fieldset[2]/legend"));
        WebElement cardType = driver.findElement(By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000452010925\"]/div/div/form/fieldset[2]/div[1]/label"));
        WebElement cardNumber = driver.findElement(By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000452010925\"]/div/div/form/fieldset[2]/div[2]/label"));
        WebElement cardholderName = driver.findElement(By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000452010925\"]/div/div/form/fieldset[2]/div[3]/label"));
        WebElement verificationCode = driver.findElement(By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000452010925\"]/div/div/form/fieldset[2]/div[4]/label"));

        WebElement cancel = driver.findElement(By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000452010925\"]/div/div/form/div/a"));
        WebElement placeOrder = driver.findElement(By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000452010925\"]/div/div/form/div/button"));

        Assert.assertEquals("Customer Info", customerInfo.getText());
        Assert.assertTrue(email.isDisplayed());
        Assert.assertTrue(name.isDisplayed());
        Assert.assertTrue(address.isDisplayed());

        Assert.assertEquals("Payment", payment.getText());
        Assert.assertTrue(cardType.isDisplayed());
        Assert.assertTrue(cardNumber.isDisplayed());
        Assert.assertTrue(cardholderName.isDisplayed());
        Assert.assertTrue(verificationCode.isDisplayed());

        Assert.assertTrue(cancel.isDisplayed());
        Assert.assertTrue(placeOrder.isDisplayed());
        Assert.assertEquals("http://www.practiceselenium.com/menu.html", cancel.getAttribute("href"));

        driver.close();
        driver.quit();
    }

    @Test
    public void fillInFields_PressCancel() {
        WebDriver driver = new ChromeDriver();
        openCheckOutPage(driver);

        WebElement email = driver.findElement(By.id("email"));
        WebElement name = driver.findElement(By.id("name"));
        WebElement address = driver.findElement(By.id("address"));
        Select cardType = new Select(driver.findElement(By.id("card_type")));
        WebElement cardNumber = driver.findElement(By.id("card_number"));
        WebElement cardholderName = driver.findElement(By.id("cardholder_name"));
        WebElement verificationCode = driver.findElement(By.id("verification_code"));

        email.sendKeys("jsmith@test.com");
        name.sendKeys("John Smith");
        address.sendKeys("1 Test Street, Testville, ON");
        cardType.selectByVisibleText("Visa");
        cardNumber.sendKeys("123456789");
        cardholderName.sendKeys("John Smith");
        verificationCode.sendKeys("24ZTEW19M");

        WebElement cancel = driver.findElement(By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000452010925\"]/div/div/form/div/a"));
        cancel.click();

        driver.close();
        driver.quit();
    }

    @Test
    public void fillInFields_PressPlaceOrder() {
        WebDriver driver = new ChromeDriver();
        openCheckOutPage(driver);

        WebElement email = driver.findElement(By.id("email"));
        WebElement name = driver.findElement(By.id("name"));
        WebElement address = driver.findElement(By.id("address"));
        Select cardType = new Select(driver.findElement(By.id("card_type")));
        WebElement cardNumber = driver.findElement(By.id("card_number"));
        WebElement cardholderName = driver.findElement(By.id("cardholder_name"));
        WebElement verificationCode = driver.findElement(By.id("verification_code"));

        email.sendKeys("jsmith@test.com");
        name.sendKeys("John Smith");
        address.sendKeys("1 Test Street, Testville, ON");
        cardType.selectByVisibleText("Visa");
        cardNumber.sendKeys("123456789");
        cardholderName.sendKeys("John Smith");
        verificationCode.sendKeys("24ZTEW19M");

        WebElement placeOrder = driver.findElement(By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000452010925\"]/div/div/form/div/button"));
        placeOrder.click();

        driver.close();
        driver.quit();
    }

    public void openCheckOutPage(WebDriver driver) {
        driver.get("http://www.practiceselenium.com/");
        driver.findElement(By.linkText("Check Out")).click();
    }
}
