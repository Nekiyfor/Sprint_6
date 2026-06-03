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


    public ImportantQuestionsPage (WebDriver driver) {
        this.driver = driver;
    }
    //Метод ожидания загрузки блока вопросов, и проскролла к нему
    public void waitAndScrollForAccordion(){
        new WebDriverWait(driver, ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(accordion));
        WebElement element = driver.findElement(accordion);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    //Здесь и далее методы клика по вопросам
    public void que_ofCostClick() {
        driver.findElement(que_ofCost).click();
    }

    public void que_ofQuantityClick() {
        driver.findElement(que_ofQuantity).click();
    }

    public void que_ofRentTimeClick() {
        driver.findElement(que_ofRentTime).click();
    }

    public void que_ofOrderTodayClick() {
        driver.findElement(que_ofOrderToday).click();
    }

    public void que_ofChangingRentTimeClick() {
        driver.findElement(que_ofChangingRentTime).click();
    }

    public void que_ofChargeClick() {
        driver.findElement(que_ofCharge).click();
    }

    public void que_ofCancelOrderClick() {
        driver.findElement(que_ofCancelOrder).click();
    }

    public void que_ofLifeInEbenyaClick() {
        driver.findElement(que_ofLifeInEbenya).click();
    }

    //Здесь и далее методы получения текста из ответа
    public String ans_ofCostText(){
        new WebDriverWait(driver, ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(ans_ofCost));
        return driver.findElement(ans_ofCost).getText();
    }

    public String ans_ofQuantityText(){
        new WebDriverWait(driver, ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(ans_ofQuantity));
        return driver.findElement(ans_ofQuantity).getText();
    }

    public String ans_ofRentTimeText(){
        new WebDriverWait(driver, ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(ans_ofRentTime));
        return driver.findElement(ans_ofRentTime).getText();
    }

    public String ans_ofOrderTodayText(){
        new WebDriverWait(driver, ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(ans_ofOrderToday));
        return driver.findElement(ans_ofOrderToday).getText();
    }

    public String ans_ofChangingRentTimeText(){
        new WebDriverWait(driver, ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(ans_ofChangingRentTime));
        return driver.findElement(ans_ofChangingRentTime).getText();
    }

    public String ans_ofChargeText(){
        new WebDriverWait(driver, ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(ans_ofCharge));
        return driver.findElement(ans_ofCharge).getText();
    }

    public String ans_ofCancelOrderText(){
        new WebDriverWait(driver, ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(ans_ofCancelOrder));
        return driver.findElement(ans_ofCancelOrder).getText();
    }

    public String ans_ofLifeInEbenyaText(){
        new WebDriverWait(driver, ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(ans_ofLifeInEbenya));
        return driver.findElement(ans_ofLifeInEbenya).getText();
    }

}
