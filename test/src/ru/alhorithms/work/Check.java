package ru.alhorithms.work;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Check {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vasilevichvv\\Desktop\\Java\\test\\src\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://83.229.175.94:15000/netaccess/loginuser.html");

        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys("sue_mto");

        element = driver.findElement(By.name("password"));
        element.sendKeys("Te1b3cyi2K");

        element = driver.findElement(By.name("Login"));
        element.click();

        driver.quit();
    }

}
