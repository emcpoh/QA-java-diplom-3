package xxx.base;

import io.restassured.RestAssured;
import xxx.apiClient.UserClient;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import xxx.models.User;
import xxx.pages.*;

public abstract class BaseTest {
    public static final String BASE_URL = "https://stellarburgers.nomoreparties.site";

    protected WebDriver driver;
    protected Faker faker;
    protected UserClient userClient  = new UserClient();

    protected User user;
    protected String accessToken;

    protected MainPage mainPage;
    protected LoginPage loginPage;
    protected RegisterPage registerPage;
    protected ForgotPassPage forgotPassPage;
    protected ProfilePage profilePage;

    @BeforeEach
    public void setUp() {
        String browserName = System.getProperty("browser");
        driver = WebDriverFactory.getDriver(browserName);

        RestAssured.baseURI = BASE_URL + "/api";

        faker = new Faker();

        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);
        forgotPassPage = new ForgotPassPage(driver);
        profilePage = new ProfilePage(driver);
    }

    @AfterEach
    public void tearDown() {
        if (accessToken != null && !accessToken.isEmpty()) {
            userClient.delete(accessToken)
                    .statusCode(202);
        }

        if (driver != null) {
            driver.quit();
        }
    }
}
