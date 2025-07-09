package xxx.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import xxx.base.BaseTest;

import java.time.Duration;

public class MainPage {

    private final WebDriver driver;
    public static final String URL = BaseTest.BASE_URL;

    // Кнопка "Войти в аккаунт"
    private final By loginButton = By.xpath(".//button[text()='Войти в аккаунт']");
    // Кнопка "Личный кабинет"
    private final By personalAccountButton = By.xpath(".//p[text()='Личный Кабинет']");
    // Логотип Stellar Burgers
    private final By logo = By.className("AppHeader_header__logo__2D0X2");
    // Заголовок "Соберите бургер"
    private final By assembleBurgerHeader = By.xpath(".//h1[text()='Соберите бургер']");
    // Раздел "Булки"
    private final By bunsSection = By.xpath(".//span[text()='Булки']");
    // Раздел "Соусы"
    private final By saucesSection = By.xpath(".//span[text()='Соусы']");
    // Раздел "Начинки"
    private final By fillingsSection = By.xpath(".//span[text()='Начинки']");
    // Активный раздел (чтобы проверять переключения)
    private final By activeSection = By.xpath(".//div[contains(@class, 'tab_tab_type_current')]/span");


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открыть главную страницу")
    public void open() {
        driver.get(URL);
    }

    @Step("Нажать на кнопку 'Войти в аккаунт'")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    @Step("Нажать на кнопку 'Личный кабинет'")
    public void clickPersonalAccountButton() {
        driver.findElement(personalAccountButton).click();
    }

    @Step("Проверить, что главная страница загружена")
    public boolean isMainPageLoaded() {
        return driver.findElement(assembleBurgerHeader).isDisplayed();
    }

    @Step("Нажать на раздел 'Булки'")
    public void clickBunsSection() {
        driver.findElement(bunsSection).click();
    }

    @Step("Нажать на раздел 'Соусы'")
    public void clickSaucesSection() {
        driver.findElement(saucesSection).click();
    }

    @Step("Нажать на раздел 'Начинки'")
    public void clickFillingsSection() {
        driver.findElement(fillingsSection).click();
    }

    @Step("Получить название активного раздела")
    public String getActiveSectionName() {
        return driver.findElement(activeSection).getText();
    }

    @Step("Ожидание загрузки главной страницы (конструктора)")
    public void waitForMainPageLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(assembleBurgerHeader));
    }
}
