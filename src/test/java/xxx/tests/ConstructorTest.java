package xxx.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import xxx.base.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Раздел 'Конструктор'")
public class ConstructorTest extends BaseTest {

    @Test
    @DisplayName("Переход к разделу 'Булки'")
    public void switchToBunsSectionTest() {
        mainPage.open();
        //  булки открыты по умолчанию, поэтому сначала кликнем на другой раздел
        mainPage.clickSaucesSection();
        mainPage.clickBunsSection();
        assertEquals("Булки", mainPage.getActiveSectionName(), "Раздел 'Булки' не активен");
    }

    @Test
    @DisplayName("Переход к разделу 'Соусы'")
    public void switchToSaucesSectionTest() {
        mainPage.open();
        mainPage.clickSaucesSection();
        assertEquals("Соусы", mainPage.getActiveSectionName(), "Раздел 'Соусы' не активен");
    }

    @Test
    @DisplayName("Переход к разделу 'Начинки'")
    public void switchToFillingsSectionTest() {
        mainPage.open();
        mainPage.clickFillingsSection();
        assertEquals("Начинки", mainPage.getActiveSectionName(), "Раздел 'Начинки' не активен");
    }
}
