package xxx.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import xxx.base.BaseTest;

public class LoginPage {
    private final WebDriver driver;

    public static final String URL = BaseTest.BASE_URL + "/login";

    // Поле "Email"
    private final By emailField = By.xpath(".//label[text()='Email']/../input");
    // Поле "Пароль"
    private final By passwordField = By.xpath(".//label[text()='Пароль']/../input");
    // Кнопка "Войти"
    private final By loginButton = By.xpath(".//button[text()='Войти']");
    // Ссылка "Зарегистрироваться"
    private final By registerLink = By.linkText("Зарегистрироваться");
    // Ссылка "Восстановить пароль"
    private final By forgotPasswordLink = By.linkText("Восстановить пароль");
    // Заголовок "Вход"
    private final By header = By.xpath(".//h2[text()='Вход']");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открыть страницу регистрации")
    public void open() {
        driver.get(URL);
    }

    @Step("Проверить, что страница входа загружена")
    public boolean isLoginPageLoaded() {
        return driver.findElement(header).isDisplayed();
    }

    @Step("Ввести email: {email}")
    public void setEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    @Step("Ввести пароль: {password}")
    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Нажать кнопку 'Войти'")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    @Step("Выполнить вход в систему с email: {email} и паролем: {password}")
    public void login(String email, String password) {
        setEmail(email);
        setPassword(password);
        clickLoginButton();
    }
}
