package xxx.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import xxx.base.BaseTest;

public class ForgotPassPage {
    private final WebDriver driver;

    private final String URL = BaseTest.BASE_URL + "/forgot-password";

    private final By loginLink = By.linkText("Войти");

    public ForgotPassPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открыть страницу регистрации")
    public void open() {
        driver.get(URL);
    }

    @Step("Нажать на ссылку 'Войти' на странице восстановления пароля")
    public void clickLoginLink() {
        driver.findElement(loginLink).click();
    }
}