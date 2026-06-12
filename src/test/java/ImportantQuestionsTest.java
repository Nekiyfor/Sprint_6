import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import qa_scooter_POM.ImportantQuestionsPage;

import java.util.stream.Stream;

public class ImportantQuestionsTest {
    private WebDriver driver;
    private ImportantQuestionsPage objImportantQuestionsPage;

    @BeforeEach
    void setUP() {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.education-services.ru/");
        objImportantQuestionsPage = new ImportantQuestionsPage(driver);
    }

    @ParameterizedTest
    @MethodSource("provideImportantQuestions")
    void testImportantQuestion(String questionKey, String ansLocator, String expectedAnswer) {
        objImportantQuestionsPage.waitAndScrollForAccordion();
        objImportantQuestionsPage.clickQuestion(questionKey);
        String actualAnswer = objImportantQuestionsPage.getAnswerText(ansLocator);
        Assertions.assertTrue(actualAnswer.contains(expectedAnswer), "Ответ не соответствует вопросу: " + questionKey);
    }

    private static Stream<Arguments> provideImportantQuestions() {
        return Stream.of(
                Arguments.of("que_ofCost", "ans_ofCostText", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."),
                Arguments.of("que_ofQuantity", "ans_ofQuantityText", "Пока что у нас так: один заказ — один самокат. " +
                        "Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."),
                Arguments.of("que_ofRentTime", "ans_ofRentTimeText", "Допустим, вы оформляете заказ на 8 мая. " +
                        "Мы привозим самокат 8 мая в течение дня. " +
                        "Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. " +
                        "Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."),
                Arguments.of("que_ofOrderToday", "ans_ofOrderTodayText", "Только начиная с завтрашнего дня. Но скоро станем расторопнее."),
                Arguments.of("que_ofChangingRentTime", "ans_ofChangingRentTimeText", "Пока что нет! Но если что-то срочное — " +
                        "всегда можно позвонить в поддержку по красивому номеру 1010."),
                Arguments.of("que_ofCharge", "ans_ofChargeText", "Самокат приезжает к вам с полной зарядкой. " +
                        "Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."),
                Arguments.of("que_ofCancelOrder", "ans_ofCancelOrderText", "Да, пока самокат не привезли. " +
                        "Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."),
                Arguments.of("que_ofLifeInEbenya", "ans_ofLifeInEbenyaText", "Да, обязательно. Всем самокатов! И Москве, и Московской области.")
        );
    }


    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
