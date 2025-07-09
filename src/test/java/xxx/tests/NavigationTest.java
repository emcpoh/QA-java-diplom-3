package xxx.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import xxx.base.BaseTest;
import xxx.models.User;
import xxx.util.DataGenerator;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Навигация по приложению")
public class NavigationTest extends BaseTest {

    @BeforeEach
    @Override
    public void setUp() {
        super.setUp();
        this.user = DataGenerator.generateValidUserRequestBody();
        this.accessToken = userClient.create(this.user)
                .statusCode(200)
                .extract()
                .path("accessToken");
        loginPage.open();
        loginPage.login(user.getEmail(), user.getPassword());
        mainPage.waitForMainPageLoad();
    }

    @Test
    @DisplayName("Переход в личный кабинет")
    public void navigateToPersonalAccountTest() {
        mainPage.clickPersonalAccountButton();
        profilePage.waitForProfilePageLoad();
        assertTrue(profilePage.isProfilePageLoaded(), "Не удалось перейти в личный кабинет");
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на 'Конструктор'")
    public void navigateFromProfileToConstructorTest() {
        mainPage.clickPersonalAccountButton();
        profilePage.waitForProfilePageLoad();
        profilePage.clickConstructorLink();
        assertTrue(mainPage.isMainPageLoaded(), "Не удалось перейти в конструктор");
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на лого")
    public void navigateFromProfileToConstructorByLogoTest() {
        mainPage.clickPersonalAccountButton();
        profilePage.waitForProfilePageLoad();
        profilePage.clickLogo();
        assertTrue(mainPage.isMainPageLoaded(), "Не удалось перейти в конструктор по клику на лого");
    }
}
