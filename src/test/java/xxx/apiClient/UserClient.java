package xxx.apiClient;

import xxx.models.User;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class UserClient {
    private static final String CREATE_PATH = "/auth/register";
    private static final String DELETE_PATH = "/auth/user";

    @Step("Создать пользователя")
    public ValidatableResponse create(User body) {
        return given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post(CREATE_PATH)
                .then();
    }

    @Step("Удалить пользователя")
    public ValidatableResponse delete(String token) {
        return given()
                .header("Authorization", token)
                .when()
                .delete(DELETE_PATH)
                .then();
    }
}

