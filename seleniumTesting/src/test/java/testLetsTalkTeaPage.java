import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class testLetsTalkTeaPage {
    @Before
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "/Users/pivotal/drivers/chromedriver");
    }

    @Test
    public void testOnLaunch_UIElementsAreVisible() {
        WebDriver driver = new ChromeDriver();
        openTalkTeaPage(driver);
        WebElement talkTeaTitle = driver.findElement(By.cssSelector("#wsb-element-00000000-0000-0000-0000-000450914913 > div > h1"));
        WebElement map = driver.findElement(By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000450914907\"]/div/div/iframe"));
        WebElement ourInfoTitle = driver.findElement(By.cssSelector("#wsb-element-00000000-0000-0000-0000-000450914908 > div > h2"));
        WebElement ourInfoDescription = driver.findElement(By.cssSelector("#wsb-element-00000000-0000-0000-0000-000450914911 > div > p:nth-child(2)"));
        WebElement ourInfoAddress = driver.findElement(By.id("wsb-element-00000000-0000-0000-0000-000450914917"));
        WebElement ourInfoNumber = driver.findElement(By.id("wsb-element-00000000-0000-0000-0000-000450914917"));
        WebElement emailTitle = driver.findElement(By.cssSelector("#wsb-element-00000000-0000-0000-0000-000450914909 > div > h2"));
        WebElement name = driver.findElement(By.cssSelector("#form_78ea690540a24bd8b9dcfbf99e999fea > div.form-body > div:nth-child(1) > label"));
        WebElement email = driver.findElement(By.xpath("//*[@id=\"form_78ea690540a24bd8b9dcfbf99e999fea\"]/div[1]/div[2]/label"));
        WebElement subject = driver.findElement(By.xpath("//*[@id=\"form_78ea690540a24bd8b9dcfbf99e999fea\"]/div[1]/div[3]/label"));
        WebElement message = driver.findElement(By.xpath("//*[@id=\"form_78ea690540a24bd8b9dcfbf99e999fea\"]/div[1]/div[4]/label"));
        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"form_78ea690540a24bd8b9dcfbf99e999fea\"]/div[1]/div[5]/input"));

        Assert.assertTrue(talkTeaTitle.isDisplayed());
        Assert.assertTrue(map.isDisplayed());
        Assert.assertTrue(ourInfoTitle.isDisplayed());
        Assert.assertTrue(ourInfoDescription.isDisplayed());
        Assert.assertTrue(ourInfoAddress.isDisplayed());
        Assert.assertTrue(ourInfoNumber.isDisplayed());
        Assert.assertTrue(emailTitle.isDisplayed());
        Assert.assertTrue(name.isDisplayed());
        Assert.assertTrue(email.isDisplayed());
        Assert.assertTrue(subject.isDisplayed());
        Assert.assertTrue(message.isDisplayed());
        Assert.assertTrue(submitButton.isDisplayed());

        driver.close();
        driver.quit();
    }

    @Test
    public void testFillInForm_submitForm() {
        WebDriver driver = new ChromeDriver();
        openTalkTeaPage(driver);

        WebElement nameField = driver.findElement(By.name("name"));
        WebElement emailField = driver.findElement(By.name("email"));
        WebElement subjectField = driver.findElement(By.name("subject"));
        WebElement messageField = driver.findElement(By.name("message"));
        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"form_78ea690540a24bd8b9dcfbf99e999fea\"]/div[1]/div[5]/input"));

        nameField.sendKeys("John Smith");
        emailField.sendKeys("jsmith@test.com");
        subjectField.sendKeys("testing123");
        messageField.sendKeys("This is a test message!");
        submitButton.click();

        driver.close();
        driver.quit();
    }

    public void openTalkTeaPage(WebDriver driver) {
        driver.get("http://www.practiceselenium.com/");
        driver.findElement(By.linkText("Let's Talk Tea")).click();
    }
}
