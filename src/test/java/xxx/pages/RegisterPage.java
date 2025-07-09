package xxx.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import xxx.base.BaseTest;

import java.time.Duration;

public class RegisterPage {
    private final WebDriver driver;

    public static final String URL = BaseTest.BASE_URL + "/register";

    // Поле "Имя"
    private final By nameField = By.xpath(".//label[text()='Имя']/../input");
    // Поле "Email"
    private final By emailField = By.xpath(".//label[text()='Email']/../input");
    // Поле "Пароль"
    private final By passwordField = By.xpath(".//label[text()='Пароль']/../input");
    // Кнопка "Зарегистрироваться"
    private final By registerButton = By.xpath(".//button[text()='Зарегистрироваться']");
    // Ссылка "Войти"
    private final By loginLink = By.linkText("Войти");
    // Сообщение об ошибке пароля
    private final By passwordError = By.xpath(".//p[text()='Некорректный пароль']");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открыть страницу регистрации")
    public void open() {
        driver.get(URL);
    }

    @Step("Ввести имя: {name}")
    public void setName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    @Step("Ввести email: {email}")
    public void setEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    @Step("Ввести пароль: {password}")
    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Нажать кнопку 'Зарегистрироваться'")
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    @Step("Выполнить регистрацию. Имя: {name}, Email: {email}, Пароль: {password}")
    public void register(String name, String email, String password) {
        setName(name);
        setEmail(email);
        setPassword(password);
        clickRegisterButton();
    }

    @Step("Проверить видимость ошибки 'Некорректный пароль'")
    public boolean isPasswordErrorVisible() {
        return driver.findElement(passwordError).isDisplayed();
    }

    @Step("Нажать на ссылку 'Войти'")
    public void clickLoginLink() {
        driver.findElement(loginLink).click();
    }

    @Step("Ожидать загрузки страницы входа")
    public void waitForLoginPageLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlToBe(LoginPage.URL));
    }
}