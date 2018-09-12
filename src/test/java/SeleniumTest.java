import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class SeleniumTest {

    WebDriver driver;

    @Before
    public void setup() {
        //driver = new ChromeDriver();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.google.com");
    }

    @After
    public void quitBrowser() {
        driver.quit();
    }

    @Test
    public void testEnter ()
    {
        String expected = "French language - Wikipedia";

        WebElement barreRecherche = driver.findElement(By.id("lst-ib"));
        barreRecherche.sendKeys("french");
        barreRecherche.sendKeys(Keys.ENTER);

        WebElement firstResult = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[2]/div/div/div/div/h3/a"));
        Assert.assertEquals(expected, firstResult.getText());
    }

    @Test
    public void testClick () throws InterruptedException
    {
        String expected = "French language - Wikipedia";
        WebElement barreRecherche = driver.findElement(By.id("lst-ib"));
        barreRecherche.sendKeys("french");
        WebElement buttonRecherche = driver.findElement(By.className("lsb"));
        buttonRecherche.click();
        WebElement firstResult = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[2]/div/div/div/div/h3/a"));
        Assert.assertEquals(expected, firstResult.getText());
   }

}
