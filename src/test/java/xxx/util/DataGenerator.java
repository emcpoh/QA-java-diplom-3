package xxx.util;

import com.github.javafaker.Faker;
import xxx.models.User;

public final class DataGenerator {
    private static final Faker FAKER = new Faker();

    private DataGenerator() {}

    public static String generateValidEmail() {
        return FAKER.internet().emailAddress();
    }

    public static String generateValidPassword() {
        return FAKER.internet().password(8, 16, true, true);
    }

    public static String generateValidFirstName() {
        return FAKER.name().firstName();
    }

    public static User generateValidUserRequestBody() {
        return new User(
                generateValidEmail(),
                generateValidPassword(),
                generateValidFirstName()
        );
    }
}
