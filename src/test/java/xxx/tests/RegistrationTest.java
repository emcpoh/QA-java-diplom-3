package xxx.tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import xxx.base.BaseTest;
import xxx.models.User;
import xxx.util.DataGenerator;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Регистрация")
public class RegistrationTest extends BaseTest {

    @Test
    @DisplayName("Успешная регистрация пользователя")
    @Description("Проверяем, что пользователь может успешно зарегистрироваться с валидными данными")
    public void successfulRegistrationTest() {
        User newUser = DataGenerator.generateValidUserRequestBody();
        registerPage.open();
        registerPage.register(newUser.getName(), newUser.getEmail(), newUser.getPassword());

        registerPage.waitForLoginPageLoad();
        assertTrue(loginPage.isLoginPageLoaded(), "Страница входа не загрузилась после регистрации");
    }

    @Test
    @DisplayName("Регистрация с некорректным паролем")
    @Description("Проверяем, что при вводе пароля короче 6 символов появляется ошибка")
    public void registrationWithIncorrectPasswordTest() {
        User newUser = DataGenerator.generateValidUserRequestBody();
        registerPage.open();
        String shortPassword = faker.internet().password(1, 5);
        registerPage.register(newUser.getName(), newUser.getEmail(), shortPassword);

        assertTrue(registerPage.isPasswordErrorVisible(), "Сообщение об ошибке пароля не отображается");
    }
}