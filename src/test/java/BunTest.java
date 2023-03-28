import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {
    Bun bun = new Bun("Флюоресцентная булка R2-D3", 988);

    @Test
    public void getNameSuccessfully() {
        String actual = bun.getName();
        String expected = "Флюоресцентная булка R2-D3";
        assertEquals(expected, actual);
    }

    @Test
    public void getPriceSuccessfully() {
        float actual = bun.getPrice();
        float expected = 988;
        assertEquals(expected, actual, 0);
    }
}