import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class BurgerTest {
    private Burger burger;
    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @BeforeEach
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void checkSetBuns() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun, "Установлено не верное название и цена булочки");
    }

    @Test
    public void checkAddIngredient() {
        burger.addIngredient(ingredient);
        assertEquals(1, burger.ingredients.size(), "Установлено не верное название и цена булочки");
    }

    @Test
    public void checkRemoveIngredient() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertTrue(burger.ingredients.isEmpty(), "Ингридиент не удалился");
    }

    @Test
    public void checkMoveIngredient() {
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "cutlet", 100));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "hot sauce", 100));
        burger.moveIngredient(0, 1);
        String expectedNameIngredient = "hot sauce";
        String actualNameIngredient = burger.ingredients.get(0).name;
        assertEquals(expectedNameIngredient, actualNameIngredient, "Неверное имя ингредиента");
    }

    @Test
    public void checkBurgerGetPrice() {
        Mockito.when(ingredient.getPrice()).thenReturn(200.11F);
        Mockito.when(bun.getPrice()).thenReturn(100F);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        float actualPrice = burger.getPrice();
        float expectedPrice = 600.22F;
        assertEquals(expectedPrice, actualPrice, 0);
    }

    @Test
    public void checkGetReceipt() {
        Mockito.when(bun.getName()).thenReturn("red bun");
        Mockito.when(bun.getPrice()).thenReturn(300F);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getName()).thenReturn("cutlet");
        Mockito.when(ingredient.getPrice()).thenReturn(100F);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        String actualReceipt = burger.getReceipt();
        String expectedReceipt = "(==== red bun ====)\r\n= filling cutlet =\r\n(==== red bun ====)\r\n\r\nPrice: 700,000000\r\n";
        assertEquals(expectedReceipt, actualReceipt);
    }
}