import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.*;

@RunWith(Parameterized.class)
public class ParameterizedIngredientTest {
    Ingredient ingredient;
    private IngredientType type;
    private String name;
    private float price;

    public ParameterizedIngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] ingredientData() {
        return new Object[][]{
                {SAUCE, "hot sauce", 100},
                {SAUCE, "chili sauce", 300},
                {FILLING, "dinosaur", 200},
                {FILLING, "sausage", 300}
        };
    }

    @Before
    public void setUp() {
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void getPriceSuccessfully() {
        float expected = price;
        float actual = ingredient.getPrice();
        assertEquals("Неверная цена для ингредиента", expected, actual, 0);
    }

    @Test
    public void getNameSuccessfully() {
        String expected = name;
        String actual = ingredient.getName();
        assertEquals("Неверное название для ингредиента", expected, actual);
    }

    @Test
    public void getIngredientTypeSuccessfully() {
        IngredientType expected = type;
        IngredientType actual = ingredient.getType();
        assertEquals("Возвращен неверный тип ингридиента", expected, actual);
    }
}
