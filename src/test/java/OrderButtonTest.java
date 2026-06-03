import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import qa_scooter_POM.MainPage;

import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderButtonTest {
    private WebDriver driver;
    private MainPage objMainPage;


    @BeforeEach
    void SetUp() {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.education-services.ru/");
        objMainPage = new MainPage(driver);

    }

    @Test
    public void testOderButtonHeader() {
        objMainPage.clickOrderButtonHeader();
        WebDriverWait wait = new WebDriverWait(driver, ofSeconds(5));
        boolean isNextPageLoaded = wait.until(ExpectedConditions.urlContains("https://qa-scooter.education-services.ru/order"));

        assertTrue(isNextPageLoaded, "Не удалось перейти на страницу оформления заказа");
    }

    @Test
    public void testOderButton() {
        objMainPage.scrollAndClickOrderButton();
        WebDriverWait wait = new WebDriverWait(driver, ofSeconds(5));
        boolean isNextPageLoaded = wait.until(ExpectedConditions.urlContains("https://qa-scooter.education-services.ru/order"));

        assertTrue(isNextPageLoaded, "Не удалось перейти на страницу оформления заказа");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}

