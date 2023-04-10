import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import praktikum.Database;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class DatabaseTest {
    private Database db;

    @BeforeEach
    public void setUp() {
        db = new Database();
    }

    @Test
    public void getAvailableBuns() {
        assertFalse(db.availableBuns().isEmpty(), "Список AvailableBuns пуст");
    }

    @Test
    public void getAvailableIngredients() {
        assertFalse(db.availableIngredients().isEmpty(), "Список AvailableIngredients пуст");
    }
}
