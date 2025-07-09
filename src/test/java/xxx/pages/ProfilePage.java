package xxx.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import xxx.base.BaseTest;

import java.time.Duration;
import java.util.Objects;

public class ProfilePage {
    private final WebDriver driver;

    // URL личного кабинета
    public static final String URL = BaseTest.BASE_URL + "/account/profile";

    // Кнопка "Выход"
    private final By logoutButton = By.xpath(".//button[text()='Выход']");
    // Ссылка на "Конструктор" в хедере
    private final By constructorLink = By.xpath(".//p[text()='Конструктор']");
    // Логотип Stellar Burgers в хедере
    private final By logo = By.className("AppHeader_header__logo__2D0X2");
    // Ссылка "Профиль" для проверки загрузки страницы
    private final By profileLink = By.linkText("Профиль");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Ожидание загрузки страницы личного кабинета")
    public void waitForProfilePageLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(profileLink));
    }

    @Step("Проверить, что страница личного кабинета загружена")
    public boolean isProfilePageLoaded() {
        return Objects.equals(driver.getCurrentUrl(), URL);
    }

    @Step("Нажать на кнопку 'Выход'")
    public void clickLogoutButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
    }

    @Step("Нажать на ссылку 'Конструктор'")
    public void clickConstructorLink() {
        driver.findElement(constructorLink).click();
    }

    @Step("Нажать на логотип Stellar Burgers")
    public void clickLogo() {
        driver.findElement(logo).click();
    }
}
