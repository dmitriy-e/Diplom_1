import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import praktikum.Bun;
import utils.StringRandomizer;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParameterizedBunNameTest {
    private static Stream<Arguments> bunDataProvider() {
        return Stream.of(
                Arguments.of(StringRandomizer.generateAlphaNumericString(1)),
                Arguments.of(StringRandomizer.generateAlphaNumericString(200000))
        );
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "   ", "\t", "\n"})
    public void checkNameNullEmptyAndBlank(String name) {
        Bun bun = new Bun(name, Float.MIN_VALUE);
        assertTrue(bun.getName() == null || bun.getName().trim().isEmpty());
    }

    @ParameterizedTest
    @MethodSource("bunDataProvider")
    public void checkNameWithParamString(String name) {
        Bun bun = new Bun(name, Float.MIN_VALUE);
        assertTrue(bun.getName().length() > 0);
    }
}