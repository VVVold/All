package ru.alhorithms.work;


        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.interactions.Actions;

public class Selenium2Example  {

    private static WebElement element;

    public static void main(String[] args) throws Exception {

        System.setProperty("webdriver.chrome.driver", "D:\\All\\test\\src\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://sue.roskazna.ru");

        if (!driver.getTitle().equals("ПО СУЭ ФК: Имя входа")) {
            element = driver.findElement(By.name("login"));
            element.click();


            element = driver.findElement(By.name("username"));
            element.sendKeys("sue_mto");

            element = driver.findElement(By.name("password"));
            element.sendKeys("Te1b3cyi2K");

            element = driver.findElement(By.name("Login"));
            element.click();
        }

        driver.get("https://sue.roskazna.ru");

        element = driver.findElement(By.name("user.id"));
        element.sendKeys("ВАСИЛЕВИЧ ВВ");

        element = driver.findElement(By.id("LoginPassword"));
        element.sendKeys("Egjhcndj");

        element = driver.findElement(By.id("loginBtn"));
        element.click();

        Thread.sleep(900);

        element = driver.findElement(By.xpath("//*[@id=\"ext-gen96\"]"));
        Actions mouse = new Actions(driver);
        mouse.moveToElement(element).click().build().perform();

        Thread.sleep(900);

        element = driver.findElement(By.xpath("//*[@id=\"ROOT/Управление инцидентами/Управление инцидентами\"]/img[1]"));
        mouse = new Actions(driver);
        mouse.moveToElement(element).click().build().perform();

        Thread.sleep(900);

        element = driver.findElement(By.xpath("//*[@id=\"ROOT/Управление инцидентами/Управление инцидентами/Поиск инцидентов\"]"));
        mouse = new Actions(driver);
        mouse.moveToElement(element).click().build().perform();

        Thread.sleep(5000);

        element = driver.findElement(By.id("ext-gen151")).findElement(By.id("ext-gen156")).findElement(By.id("X10"));
        mouse = new Actions(driver);
        mouse.moveToElement(element).click().build().perform();

//        element = driver.findElement(By.xpath("//*[@id=\"X10Border\"]"));
//        element.sendKeys("q");




    }
}
