package ru.alhorithms.work;


        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.support.ui.ExpectedCondition;
        import org.openqa.selenium.support.ui.WebDriverWait;

public class Selenium2Example  {
    public static void main(String[] args) {
        // Create a new instance of the Firefox driver
        // Notice that the remainder of the code relies on the interface,
        // not the implementation.


//        // And now use this to visit Google
//        driver.get("http://www.google.com");
//        // Alternatively the same thing can be done like this
//        // driver.navigate().to("http://www.google.com");
//
//        // Find the text input element by its name
//        WebElement element = driver.findElement(By.name("q"));
//
//        // Enter something to search for
//        element.sendKeys("Cheese!");
//
//        // Now submit the form. WebDriver will find the form for us from the element
//        element.submit();
//
//        // Check the title of the page
//        System.out.println("Page title is: " + driver.getTitle());
//
//        // Google's search is rendered dynamically with JavaScript.
//        // Wait for the page to load, timeout after 10 seconds
//        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
//            public Boolean apply(WebDriver d) {
//                return d.getTitle().toLowerCase().startsWith("cheese!");
//            }
//        });
//
//        // Should see: "cheese! - Google Search"
//        System.out.println("Page title is: " + driver.getTitle());
//
////        Close the browser
//        driver.quit();

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vasilevichvv\\Desktop\\All\\test\\src\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://83.229.175.94:15000/netaccess/loginuser.html");

        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys("sue_mto");

        element = driver.findElement(By.name("password"));
        element.sendKeys("Te1b3cyi2K");

        element = driver.findElement(By.name("Login"));


//        try {
//            Thread.sleep(100000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        driver.quit();




        WebDriver driver1 = new ChromeDriver();
        driver1.get("https://sue.roskazna.ru");

        element = driver1.findElement(By.name("user.id"));
        element.sendKeys("ВАСИЛЕВИЧ ВВ");


        element = driver1.findElement(By.id("LoginPassword"));
        element.sendKeys("Egjhcndj");

        element = driver1.findElement(By.id("loginBtn"));
        element.click();

        element = driver1.findElement(By.id("ext-gen97"));
        element.click();

    }
}
