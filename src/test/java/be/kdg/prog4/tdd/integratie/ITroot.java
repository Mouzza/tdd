package be.kdg.prog4.tdd.integratie;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ITroot {

    @Test
    public void testAddUser() throws InterruptedException {
        WebDriver driver = new HtmlUnitDriver();
        driver.get("http://127.0.0.1:8080/tdd");
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys("root");
        element = driver.findElement(By.name("password"));
        element.sendKeys("rootpasswd");
        element.submit();
        (new WebDriverWait(driver, 10)).until((WebDriver d) -> d.getTitle().equals("Favorites: root"));
        element = driver.findElement(By.name("newusername"));
        element.sendKeys("testuser");
        element = driver.findElement(By.name("newpassword"));
        element.sendKeys("testuser");
        element.submit();
        driver = new HtmlUnitDriver();
        driver.get("http://127.0.0.1:8080/tdd");
        element = driver.findElement(By.name("username"));
        element.sendKeys("testuser");
        element = driver.findElement(By.name("password"));
        element.sendKeys("testuser");
        element.submit();
        (new WebDriverWait(driver, 10)).until((WebDriver d) -> d.getTitle().equals("Favorites: testuser"));
    }

}
