package homepage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomePageTest {

    private WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
    }

    @Test
    public void canVerifyPageTitle() {
        driver.get("https://www.testautomationu.applitools.com/");
        String actual = driver.getTitle();
        String expected = "Test Automation University | Applitools";
        assertEquals(expected, actual);
    }

}
