package qa_scooter_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;

public class ImportantQuestionsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    //Блок вопросов о важном
    private By accordion = By.xpath("//div[@class='accordion']");
    //Вопрос о стоимости
    private By que_ofCost = By.id("accordion__heading-0");
    //Вопрос о количестве самокатов
    private By que_ofQuantity = By.id("accordion__heading-1");
    //Вопрос о расчете времени аренды
    private By que_ofRentTime = By.id("accordion__heading-2");
    //Вопрос о возможности заказа на текущий день
    private By que_ofOrderToday = By.id("accordion__heading-3");
    //Вопрос о возможности изменения времени аренды
    private By que_ofChangingRentTime = By.id("accordion__heading-4");
    //Вопрос о зарядке самоката
    private By que_ofCharge = By.id("accordion__heading-5");
    //Вопрос об отмене заказа
    private By que_ofCancelOrder = By.id("accordion__heading-6");
    //Вопрос о наличии жизни за МКАДом
    private By que_ofLifeInEbenya = By.id("accordion__heading-7");

    //Ответы на вопросы
    //Ответ о стоимости
    private By ans_ofCost = By.id("accordion__panel-0");
    //Ответ о количестве самокатов
    private By ans_ofQuantity = By.id("accordion__panel-1");
    //Ответ о расчете времени аренды
    private By ans_ofRentTime = By.id("accordion__panel-2");
    //Ответ о возможности заказа на текущий день
    private By ans_ofOrderToday = By.id("accordion__panel-3");
    //Ответ о возможности изменения времени аренды
    private By ans_ofChangingRentTime = By.id("accordion__panel-4");
    //Ответ о зарядке самоката
    private By ans_ofCharge = By.id("accordion__panel-5");
    //Ответ об отмене заказа
    private By ans_ofCancelOrder = By.id("accordion__panel-6");
    //Ответ о наличии жизни за МКАДом
    private By ans_ofLifeInEbenya = By.id("accordion__panel-7");


    public ImportantQuestionsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, ofSeconds(3));
    }

    //Метод ожидания загрузки блока вопросов, и проскролла к нему
    public void waitAndScrollForAccordion() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(accordion));
        WebElement element = driver.findElement(accordion);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    //Кликаем по вопросам
    public void clickQuestion(String questionKey) {
        switch (questionKey) {
            case "que_ofCost":
                driver.findElement(que_ofCost).click();
                break;
            case "que_ofQuantity":
                driver.findElement(que_ofQuantity).click();
                break;
            case "que_ofRentTime":
                driver.findElement(que_ofRentTime).click();
                break;
            case "que_ofOrderToday":
                driver.findElement(que_ofOrderToday).click();
                break;
            case "que_ofChangingRentTime":
                driver.findElement(que_ofChangingRentTime).click();
                break;
            case "que_ofCharge":
                driver.findElement(que_ofCharge).click();
                break;
            case "que_ofCancelOrder":
                driver.findElement(que_ofCancelOrder).click();
                break;
            case "que_ofLifeInEbenya":
                driver.findElement(que_ofLifeInEbenya).click();
                break;
        }
    }

    //Получаем текст ответов на вопросы
    public String getAnswerText(String ansLocator) {
        By locator;
        switch (ansLocator) {
            case "ans_ofCostText":
                locator = ans_ofCost;
                break;
            case "ans_ofQuantityText":
                locator = ans_ofQuantity;
                break;
            case "ans_ofRentTimeText":
                locator = ans_ofRentTime;
                break;
            case "ans_ofOrderTodayText":
                locator = ans_ofOrderToday;
                break;
            case "ans_ofChangingRentTimeText":
                locator = ans_ofChangingRentTime;
                break;
            case "ans_ofChargeText":
                locator = ans_ofCharge;
                break;
            case "ans_ofCancelOrderText":
                locator = ans_ofCancelOrder;
                break;
            case "ans_ofLifeInEbenyaText":
                locator = ans_ofLifeInEbenya;
                break;
            default:
                throw new IllegalArgumentException("Нет значения для локатора: '" + ansLocator + "'");
        }
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }

}
