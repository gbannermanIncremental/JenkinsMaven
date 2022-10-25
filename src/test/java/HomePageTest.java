import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomePageTest {

    @Test
    public void canVerifyPageTitle() {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://testautomationu.applitools.com/");
        String actual = driver.getTitle();
        String expected = "Test Automation University | Applitools";
        assertEquals(expected, actual);
    }

}
