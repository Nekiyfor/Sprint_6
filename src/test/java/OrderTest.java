import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import qa_scooter_POM.OrderPage;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderTest {
    private WebDriver driver;
    private OrderPage objOrderPage;

    @BeforeEach
    void SetUp() {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.education-services.ru/order");
        objOrderPage = new OrderPage(driver);
    }

    @ParameterizedTest
    @MethodSource("orderData")
    public void testOrderForm(String firstName, String lastName, String address, String phone) {
        objOrderPage.fillForm(firstName, lastName, address, phone);
        objOrderPage.clickToNextButton();
        objOrderPage.continueOrderRegistration();
        // Падает в Хроме из-за некликабельной кнопки подтверждения заказа
        assertTrue(objOrderPage.isSuccessOrderDisplayed(), "Не отображается модалка успешного оформления заказа");
    }

    private static Stream<Arguments> orderData() {
        return Stream.of(
                Arguments.of("Степан", "Разин", "ул. Ленина, д. 1", "+79001234567"),
                Arguments.of("Мария", "Склодовская", "ул. Мира, д. 10", "+79007654321")
        );
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
