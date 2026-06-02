import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import qa_scooter_POM.ImportantQuestionsPage;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ImportantQuestionsTest {
    private WebDriver driver;
    private ImportantQuestionsPage objImportantQuestionsPage;

    @BeforeEach
    void setUP() {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.education-services.ru/");
        objImportantQuestionsPage = new ImportantQuestionsPage(driver);
    }

    @Test
    void que_ofCostTest(){
        //Здесь и далее:
        //Ожидаем загрузки блока и скроллимся к нему
        objImportantQuestionsPage.waitAndScrollForAccordion();
        //Кликаем на вопрос
        objImportantQuestionsPage.que_ofCostClick();
        //Записываем часть ожидаемого ответа в переменную
        String expAnswer = "Сутки — 400 рублей. Оплата курьеру";
        //Запрашиваем текст из локатора(поля ответа на вопрос)
        String actualAnswer = objImportantQuestionsPage.ans_ofCostText();
        //Проверяем что полученный ответ содежржит текст из ожидания, либо показываем ошибку
        assertTrue(actualAnswer.contains(expAnswer), "Ответ не соответсвует вопросу");
    }

    @Test
    void que_ofQuantityTest(){
        objImportantQuestionsPage.waitAndScrollForAccordion();
        objImportantQuestionsPage.que_ofQuantityClick();
        String expAnswer = "один заказ — один самокат";
        String actualAnswer = objImportantQuestionsPage.ans_ofQuantityText();
        assertTrue(actualAnswer.contains(expAnswer), "Ответ не соответсвует вопросу");
    }

    @Test
    void que_ofRentTimeTest(){
        objImportantQuestionsPage.waitAndScrollForAccordion();
        objImportantQuestionsPage.que_ofRentTimeClick();
        String expAnswer = "Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру";
        String actualAnswer = objImportantQuestionsPage.ans_ofRentTimeText();
        assertTrue(actualAnswer.contains(expAnswer), "Ответ не соответсвует вопросу");
    }

    @Test
    void que_ofOrderTodayTest(){
        objImportantQuestionsPage.waitAndScrollForAccordion();
        objImportantQuestionsPage.que_ofOrderTodayClick();
        String expAnswer = "Только начиная с завтрашнего дня";
        String actualAnswer = objImportantQuestionsPage.ans_ofOrderTodayText();
        assertTrue(actualAnswer.contains(expAnswer), "Ответ не соответсвует вопросу");
    }

    @Test
    void que_ofChangingRentTimeTest(){
        objImportantQuestionsPage.waitAndScrollForAccordion();
        objImportantQuestionsPage.que_ofChangingRentTimeClick();
        String expAnswer = "Пока что нет";
        String actualAnswer = objImportantQuestionsPage.ans_ofChangingRentTimeText();
        assertTrue(actualAnswer.contains(expAnswer), "Ответ не соответсвует вопросу");
    }

    @Test
    void que_ofChargeTest(){
        objImportantQuestionsPage.waitAndScrollForAccordion();
        objImportantQuestionsPage.que_ofChargeClick();
        String expAnswer = "Самокат приезжает к вам с полной зарядкой";
        String actualAnswer = objImportantQuestionsPage.ans_ofChargeText();
        assertTrue(actualAnswer.contains(expAnswer), "Ответ не соответсвует вопросу");
    }

    @Test
    void que_ofCancelOrder(){
        objImportantQuestionsPage.waitAndScrollForAccordion();
        objImportantQuestionsPage.que_ofCancelOrderClick();
        String expAnswer = "пока самокат не привезли";
        String actualAnswer = objImportantQuestionsPage.ans_ofCancelOrderText();
        assertTrue(actualAnswer.contains(expAnswer), "Ответ не соответсвует вопросу");
    }

    @Test
    void que_ofLifeInEbenya(){
        objImportantQuestionsPage.waitAndScrollForAccordion();
        objImportantQuestionsPage.que_ofLifeInEbenyaClick();
        String expAnswer = "обязательно. Всем самокатов";
        String actualAnswer = objImportantQuestionsPage.ans_ofLifeInEbenyaText();
        assertTrue(actualAnswer.contains(expAnswer), "Ответ не соответсвует вопросу");
    }


    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
