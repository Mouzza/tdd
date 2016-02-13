package be.kdg.prog4.tdd.integratie;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by kris on 24/11/14.
 */
public class ITuser {

    @Before
    public void setup() {
        WebDriver driver = new HtmlUnitDriver();
        driver.get("http://127.0.0.1:8080/tdd");
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys("root");
        element = driver.findElement(By.name("password"));
        element.sendKeys("rootpasswd");
        element.submit();
        (new WebDriverWait(driver, 10)).until((WebDriver d) -> d.getTitle().equals("Favorites: root"));
        element = driver.findElement(By.name("newusername"));
        element.sendKeys("normaluser");
        element = driver.findElement(By.name("newpassword"));
        element.sendKeys("normaluser");
        element.submit();
    }

    @Test
    public void testAddFavorite() {
        WebDriver driver = new HtmlUnitDriver();
        driver.get("http://127.0.0.1:8080/tdd");
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys("normaluser");
        element = driver.findElement(By.name("password"));
        element.sendKeys("normaluser");
        element.submit();
        (new WebDriverWait(driver, 10)).until((WebDriver d) -> d.getTitle().equals("Favorites: testuser"));
        element = driver.findElement(By.name("favorite"));
        element.sendKeys("pasta");
        element.submit();
        (new WebDriverWait(driver, 10)).until((WebDriver d) -> d.getTitle().equals("Favorites: testuser"));
        element = driver.findElement(By.name("favorites"));
        List<WebElement> rows = element.findElements(By.tagName("td"));
        assertEquals(1, rows.size());
        assertEquals("pasta", rows.get(0).getText());

        element = driver.findElement(By.name("favorite"));
        element.sendKeys("frieten");
        element.submit();
        (new WebDriverWait(driver, 10)).until((WebDriver d) -> d.getTitle().equals("Favorites: testuser"));
        element = driver.findElement(By.name("favorites"));
        rows = element.findElements(By.tagName("td"));
        assertEquals(2, rows.size());
        String favorite1 = rows.get(0).getText();
        String favorite2 = rows.get(1).getText();
        assertEquals("pasta", favorite1);
        assertEquals("frieten", favorite2);
    }

}
