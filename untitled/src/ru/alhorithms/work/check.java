package ru.alhorithms.work;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class check {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vasilevichvv\\Desktop\\All\\untitled\\src\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://suefk.roskazna.ru:8443/sm934/index.do?login_error=1&login_error_message=LogoutPage.session_timeout&lang=ru");

        WebElement element = driver.findElement(By.id("LoginUsername"));
        element.sendKeys("v.vasilevich@sitonica.ru");

        element = driver.findElement(By.id("LoginPassword"));
        element.sendKeys("Egjhcndj13");

        element = driver.findElement(By.id("loginBtn"));
        element.click();

        element = driver.findElement(By.id("ext-gen214"));
        element.click();

        element = driver.findElement(By.id("ext-gen215"));
        element.click();

    }
}
