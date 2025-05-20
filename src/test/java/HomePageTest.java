import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class HomePageTest {

    private WebDriver driver;

    @BeforeAll
    void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opts = new ChromeOptions()
                .addArguments("--headless=new", "--no-sandbox");
        driver = new ChromeDriver(opts);
    }

    @AfterAll
    void tearDown() {
        if (driver != null) driver.quit();
    }

    @Test
    void titleShouldBePetClinic() {
        driver.get("http://localhost:8080");
        Assertions.assertEquals(
                "PetClinic :: a Spring Framework demonstration",
                driver.getTitle()
        );
    }
}

