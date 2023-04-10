import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import praktikum.Bun;
import utils.StringRandomizer;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParameterizedBunPriceTest {
    @ParameterizedTest
    @ValueSource(floats = {0, Float.MIN_VALUE, Float.MAX_VALUE})
    public void checkPriceFloatParam(float price) {
        Bun bun = new Bun(StringRandomizer.generateAlphaNumericString(1), price);
        assertTrue(bun.getPrice() >= 0);
    }

    @ParameterizedTest
    @ValueSource(floats = {-1})
    public void checkPriceCanBeNegative(float price) {
        Bun bun = new Bun(StringRandomizer.generateAlphaNumericString(1), price);
        assertTrue(bun.getPrice() < 0);
    }
}