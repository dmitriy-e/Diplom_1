import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

public class ParameterizedIngredientTest {
    private static Stream<Arguments> ingredientDataProvider() {
        return Stream.of(
                Arguments.of(SAUCE, "hot sauce", 100),
                Arguments.of(SAUCE, "chili sauce", 300),
                Arguments.of(FILLING, "dinosaur", 200),
                Arguments.of(FILLING, "sausage", 300)
        );
    }

    @ParameterizedTest
    @MethodSource("ingredientDataProvider")
    public void getPriceSuccessfully(IngredientType type, String name, float price) {
        Ingredient ingredient = new Ingredient(type, name, price);
        float expected = price;
        float actual = ingredient.getPrice();
        assertEquals(expected, actual, 0, "Неверная цена для ингредиента");
    }

    @ParameterizedTest
    @MethodSource("ingredientDataProvider")
    public void getNameSuccessfully(IngredientType type, String name, float price) {
        Ingredient ingredient = new Ingredient(type, name, price);
        String expected = name;
        String actual = ingredient.getName();
        assertEquals(expected, actual, "Неверное название для ингредиента");
    }

    @ParameterizedTest
    @MethodSource("ingredientDataProvider")
    public void getIngredientTypeSuccessfully(IngredientType type, String name, float price) {
        Ingredient ingredient = new Ingredient(type, name, price);
        IngredientType expected = type;
        IngredientType actual = ingredient.getType();
        assertEquals(expected, actual, "Возвращен неверный тип ингридиента");
    }
}