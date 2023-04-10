import org.junit.jupiter.api.Test;
import praktikum.IngredientType;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IngredientTypeTest {
    @Test
    public void getSauceTypeIsCorrect() {
        assertEquals(IngredientType.valueOf("SAUCE"), IngredientType.SAUCE);
    }

    @Test
    public void getFillingTypeIsCorrect() {
        assertEquals(IngredientType.valueOf("FILLING"), IngredientType.FILLING);
    }
}
