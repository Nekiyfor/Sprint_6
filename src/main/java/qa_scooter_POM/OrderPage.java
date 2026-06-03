package qa_scooter_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static java.time.Duration.ofSeconds;


public class OrderPage {
    private WebDriver driver;
    private WebDriverWait wait;
    //Локатор формы заказа
    private By orderForm = By.xpath("//div[contains(@class, 'Order_Form')]");
    //Поле для ввода имени
    private By firstName = By.xpath("//input[contains(@placeholder, 'Имя')]");
    //Поле для ввода фамилии
    private By lastName = By.xpath("//input[contains(@placeholder, 'Фамилия')]");
    //Поле для ввода адреса
    private By address = By.xpath("//input[contains(@placeholder, 'Адрес')]");
    //Поле для ввода станции метро
    private By metro = By.xpath("//div[@class='select-search__value']");
    //Выбор первой станции метро
    private By metroStation = By.xpath("//li[@data-index='0']/button[@tabindex='-1']");
    //Поле для ввода номера телефона
    private By phone = By.xpath("//input[contains(@placeholder, 'Телефон')]");
    //Кнопка "Далее"
    private By nextButton = By.xpath("//button[text() = 'Далее']");
    //Поле ввода даты доставки самоката
    private By orderDate = By.xpath("//input[contains(@placeholder, 'привезти')]");
    //Дата доставки самоката в выпадающем календаре
    private By orderDay = By.xpath("//div[@class='react-datepicker__week']/div[contains(@tabindex, '0')]");
    //Выпадающее меню срока аренды самоката
    private By dropDownRentalPeriod = By.xpath("//div[@class='Dropdown-root']");
    //Срок аренды самоката
    private By rentalPeriod = By.xpath("//div[text()='трое суток']");
    //Кнопка "Заказать" на сранице Про аренду
    private By orderButton = By.xpath("//div[contains(@class, 'Order_Buttons')]//button[text()='Заказать']");
    //Кнопка подтверждения заказа
    private By confirmButton = By.xpath("//button[text()='Да']");
    //Модалка успешного оформления аренды
    private By successOrderModal = By.xpath("//div[text()='Заказ оформлен']");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, ofSeconds(5));
    }

    public void fillForm(String firstName, String lastName, String address, String phone) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderForm));
        driver.findElement(this.firstName).sendKeys(firstName);
        driver.findElement(this.lastName).sendKeys(lastName);
        driver.findElement(this.address).sendKeys(address);
        driver.findElement(this.metro).click();
        wait.until(ExpectedConditions.elementToBeClickable(metroStation));
        driver.findElement(metroStation).click();
        driver.findElement(this.phone).sendKeys(phone);
    }


    public void clickToNextButton() {
        wait.until(ExpectedConditions.elementToBeClickable(nextButton));
        driver.findElement(nextButton).click();
    }


    public void continueOrderRegistration() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(orderDate));
        driver.findElement(orderDate).click();
        driver.findElement(orderDay).click();
        wait.until(ExpectedConditions.elementToBeClickable(dropDownRentalPeriod));
        driver.findElement(dropDownRentalPeriod).click();
        driver.findElement(rentalPeriod).click();
        driver.findElement(orderButton).click();
        wait.until(ExpectedConditions.elementToBeClickable(confirmButton));
        driver.findElement(confirmButton).click();
    }

    public boolean isSuccessOrderDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(successOrderModal));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}