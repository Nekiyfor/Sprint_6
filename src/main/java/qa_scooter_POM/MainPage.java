package qa_scooter_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;

public class MainPage {
    private WebDriver driver;
    // Кнопка "Заказать" в Хэдере
    private By orderButtonHeader = By.xpath("//div[contains(@class, 'Header_Nav')]//button");
    //Кнопка "Заказать" в середине страницы
    private By orderButton = By.xpath("//div[contains(@class, 'Home_FinishButton')]//button");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOrderButtonHeader() {
        new WebDriverWait(driver,ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(orderButtonHeader));
        driver.findElement(orderButtonHeader).click();
    }

    public void scrollAndClickOrderButton() {
        new WebDriverWait(driver,ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(orderButton));
        WebElement element = driver.findElement(orderButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(orderButton).click();
    }
}
