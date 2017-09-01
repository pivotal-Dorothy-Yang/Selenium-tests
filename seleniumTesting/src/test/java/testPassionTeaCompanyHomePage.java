import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class testPassionTeaCompanyHomePage {
    @Before
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "/Users/pivotal/drivers/chromedriver");
    }

    @Test
    public void testOnLaunch_mainSectionUIElementsAreVisible() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.practiceselenium.com/");

        WebElement teaImage = driver.findElement(By.id("wsb-element-00000000-0000-0000-0000-000450914885"));
        WebElement h1Text = driver.findElement(By.id("wsb-element-00000000-0000-0000-0000-000450914886"));
        WebElement companyOverview = driver.findElement(By.id("wsb-element-00000000-0000-0000-0000-000450914887"));
        String overviewText = companyOverview.getText();

        WebElement herbalTeaTitle = driver.findElement(By.id("wsb-element-00000000-0000-0000-0000-000450914896"));
        WebElement herbalTeaImg = driver.findElement(By.id("wsb-element-00000000-0000-0000-0000-000450914895"));
        WebElement herbalTeaButton = driver.findElement(By.id("wsb-button-00000000-0000-0000-0000-000450914890"));

        WebElement looseTeaTitle = driver.findElement(By.id("wsb-element-00000000-0000-0000-0000-000450914894"));
        WebElement looseTeaImg = driver.findElement(By.id("wsb-element-00000000-0000-0000-0000-000450914892"));
        WebElement looseTeaButton = driver.findElement(By.id("wsb-button-00000000-0000-0000-0000-000450914897"));

        WebElement flavoredTeaTitle = driver.findElement(By.id("wsb-element-00000000-0000-0000-0000-000450914893"));
        WebElement flavoredTeaImg = driver.findElement(By.id("wsb-element-00000000-0000-0000-0000-000450914891"));
        WebElement flavoredTeaButton = driver.findElement(By.id("wsb-button-00000000-0000-0000-0000-000450914899"));

        Assert.assertTrue(teaImage.isDisplayed());
        Assert.assertEquals("We're passionate about tea. ", h1Text.getText());
        Assert.assertEquals(overviewText, companyOverview.getText());

        Assert.assertEquals("Herbal Tea", herbalTeaTitle.getText());
        Assert.assertTrue(herbalTeaImg.isDisplayed());
        Assert.assertTrue(herbalTeaButton.isDisplayed());
        Assert.assertEquals("Loose Tea", looseTeaTitle.getText());
        Assert.assertTrue(looseTeaImg.isDisplayed());
        Assert.assertTrue(looseTeaButton.isDisplayed());
        Assert.assertEquals("Flavored Tea", flavoredTeaTitle.getText());
        Assert.assertTrue(flavoredTeaImg.isDisplayed());
        Assert.assertTrue(flavoredTeaButton.isDisplayed());

        driver.close();
        driver.quit();
    }

    @Test
    public void testonLaunch_sidebarSectionUIElementsAreVisible() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.practiceselenium.com/");

        WebElement passionIconSidebar = driver.findElement(By.id("wsb-element-00000000-0000-0000-0000-000450914872"));
        WebElement teaCompanyIconSidebar = driver.findElement(By.id("wsb-element-00000000-0000-0000-0000-000450914875"));

        WebElement welcome = driver.findElement(By.linkText("Welcome"));
        WebElement ourPassion = driver.findElement(By.linkText("Our Passion"));
        WebElement menu = driver.findElement(By.linkText("Menu"));
        WebElement talkTea = driver.findElement(By.partialLinkText("Let's"));
        WebElement checkOut = driver.findElement(By.linkText("Check Out"));

        WebElement organicTeasText = driver.findElement(By.id("wsb-element-00000000-0000-0000-0000-000450914878"));
        WebElement organicTeasMore = driver.findElement(By.id("wsb-element-00000000-0000-0000-0000-000450914883"));
        WebElement organicTeasImg = driver.findElement(By.id("wsb-element-00000000-0000-0000-0000-000450914880"));

        WebElement teaOfTheMonthTitle = driver.findElement(By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000450914879\"]/div/h3/span"));
        WebElement teaOfTheMonthText = driver.findElement(By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000450914881\"]/div/p/span"));
        WebElement teaOfTheMonthMore = driver.findElement(By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000450914882\"]/div/p/a/span"));

        Assert.assertTrue(passionIconSidebar.isDisplayed());
        Assert.assertTrue(teaCompanyIconSidebar.isDisplayed());
        Assert.assertEquals("Welcome", welcome.getText());
        Assert.assertEquals("Our Passion", ourPassion.getText());
        Assert.assertEquals("Menu", menu.getText());
        Assert.assertEquals("Let's Talk Tea", talkTea.getText());
        Assert.assertEquals("Check Out", checkOut.getText());

        Assert.assertTrue(organicTeasImg.isDisplayed());
        Assert.assertEquals("See our line of organic teas.", organicTeasText.getText());
        Assert.assertEquals("More", organicTeasMore.getText());
        Assert.assertEquals("Tea of the month club", teaOfTheMonthTitle.getText());
        Assert.assertEquals("It's the gift that keeps on giving all year long.", teaOfTheMonthText.getText());
        Assert.assertEquals("More", teaOfTheMonthMore.getText());

        driver.close();
        driver.quit();
    }

    @Test
    public void testSeeCollectionLink_HaveCorrectLinks() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.practiceselenium.com/");

        WebElement herbalTeaButton = driver.findElement(By.cssSelector("#wsb-button-00000000-0000-0000-0000-000450914890"));
        WebElement looseTeaButton = driver.findElement(By.cssSelector("#wsb-button-00000000-0000-0000-0000-000450914897"));
        WebElement flavoredTeaButton = driver.findElement(By.cssSelector("#wsb-button-00000000-0000-0000-0000-000450914899"));

        String herbalTeahref = herbalTeaButton.getAttribute("href");
        String looseTeahref = looseTeaButton.getAttribute("href");
        String flavoredTeahref = flavoredTeaButton.getAttribute("href");

        String expectedLink = "http://www.practiceselenium.com/menu.html";

        Assert.assertEquals(herbalTeahref, expectedLink);
        Assert.assertEquals(looseTeahref, expectedLink);
        Assert.assertEquals(flavoredTeahref, expectedLink);
    }

    @Test
    public void testSidebarLinks_HaveCorrectLinks() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.practiceselenium.com/");

        WebElement welcome = driver.findElement(By.linkText("Welcome"));
        WebElement ourPassion = driver.findElement(By.linkText("Our Passion"));
        WebElement menu = driver.findElement(By.linkText("Menu"));
        WebElement talkTea = driver.findElement(By.partialLinkText("Let's"));
        WebElement checkOut = driver.findElement(By.linkText("Check Out"));
        WebElement organicTeasMore = driver.findElement(By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000450914883\"]/div/p/a"));
        WebElement teaOfTheMonthMore = driver.findElement(By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000450914882\"]/div/p/a"));

        String welcomehref = welcome.getAttribute("href");
        String ourPassionhref = ourPassion.getAttribute("href");
        String menuhref = menu.getAttribute("href");
        String talkTeahref = talkTea.getAttribute("href");
        String checkOuthref = checkOut.getAttribute("href");
        String organicTeashref = organicTeasMore.getAttribute("href");
        String teaOfTheMonthhref = teaOfTheMonthMore.getAttribute("href");

        Assert.assertEquals(welcomehref, "http://www.practiceselenium.com/welcome.html");
        Assert.assertEquals(ourPassionhref, "http://www.practiceselenium.com/our-passion.html");
        Assert.assertEquals(menuhref, "http://www.practiceselenium.com/menu.html");
        Assert.assertEquals(talkTeahref, "http://www.practiceselenium.com/let-s-talk-tea.html");
        Assert.assertEquals(checkOuthref, "http://www.practiceselenium.com/check-out.html");
        Assert.assertEquals(organicTeashref, "http://www.practiceselenium.com/menu.html");
        Assert.assertEquals(teaOfTheMonthhref, "http://www.practiceselenium.com/menu.html");

        driver.close();
        driver.quit();



    }
}
