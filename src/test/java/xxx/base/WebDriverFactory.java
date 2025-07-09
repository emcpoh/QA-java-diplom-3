package xxx.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.nio.file.Paths;

public class WebDriverFactory {

    public static WebDriver getDriver(String browserName) {
        if (browserName == null) {
            browserName = "chrome";
        }

        switch (browserName.toLowerCase()) {
            case "yandex":
                ChromeOptions yandexOptions = new ChromeOptions();
                ChromeDriverService service = new ChromeDriverService.Builder()
                        .usingDriverExecutable(Paths.get("src/test/resources/WebDrivers/yandexdriver.exe").toFile())
                        .build();
                yandexOptions.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
                return new ChromeDriver(service, yandexOptions);

            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
                return new ChromeDriver(chromeOptions);
            default:
                return new ChromeDriver();
        }
    }
}