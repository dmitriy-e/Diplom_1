import org.junit.Before;
import org.junit.Test;
import praktikum.Database;

import static org.junit.Assert.assertFalse;

public class DatabaseTest {
    private Database db;

    @Before
    public void setUp() {
        db = new Database();
    }

    @Test
    public void getAvailableBuns() {
        assertFalse("Список AvailableBuns пуст", db.availableBuns().isEmpty());
    }

    @Test
    public void getAvailableIngredients() {
        assertFalse("Список AvailableIngredients пуст", db.availableIngredients().isEmpty());
    }
}
