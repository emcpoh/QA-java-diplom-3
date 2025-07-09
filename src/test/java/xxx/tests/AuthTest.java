package xxx.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import xxx.base.BaseTest;
import xxx.models.User;
import xxx.util.DataGenerator;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Аутентификация (вход и выход)")
public class AuthTest extends BaseTest {

    @BeforeEach
    @Override
    public void setUp() {
        super.setUp();
        this.user = DataGenerator.generateValidUserRequestBody();
        this.accessToken = userClient.create(this.user)
                .statusCode(200)
                .extract()
                .path("accessToken");
    }

    @Test
    @DisplayName("Вход по кнопке 'Войти в аккаунт' на главной")
    public void loginFromMainPageLoginButtonTest() {
        mainPage.open();
        mainPage.clickLoginButton();
        loginPage.login(user.getEmail(), user.getPassword());

        mainPage.waitForMainPageLoad();
        assertTrue(mainPage.isMainPageLoaded(), "Главная страница не загрузилась после входа");
    }

    @Test
    @DisplayName("Вход через кнопку 'Личный кабинет'")
    public void loginFromPersonalAccountButtonTest() {
        mainPage.open();
        mainPage.clickPersonalAccountButton();
        loginPage.login(user.getEmail(), user.getPassword());

        mainPage.waitForMainPageLoad();
        assertTrue(mainPage.isMainPageLoaded(), "Главная страница не загрузилась после входа");
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void loginFromRegisterPageTest() {
        registerPage.open();
        registerPage.clickLoginLink();
        loginPage.login(user.getEmail(), user.getPassword());

        mainPage.waitForMainPageLoad();
        assertTrue(mainPage.isMainPageLoaded(), "Главная страница не загрузилась после входа");
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void loginFromForgotPasswordPageTest() {
        forgotPassPage.open();
        forgotPassPage.clickLoginLink();
        loginPage.login(user.getEmail(), user.getPassword());

        mainPage.waitForMainPageLoad();
        assertTrue(mainPage.isMainPageLoaded(), "Главная страница не загрузилась после входа");
    }

    @Test
    @DisplayName("Выход из аккаунта")
    public void logoutTest() {
        loginPage.open();
        loginPage.login(user.getEmail(), user.getPassword());
        mainPage.waitForMainPageLoad();

        mainPage.clickPersonalAccountButton();
        profilePage.waitForProfilePageLoad();
        profilePage.clickLogoutButton();
        registerPage.waitForLoginPageLoad();
        assertTrue(loginPage.isLoginPageLoaded(), "Не удалось выйти из аккаунта");
    }
}
