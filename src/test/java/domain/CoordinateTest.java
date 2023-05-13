package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import exception.OutOfRangeException;

@DisplayName("숫자에 대하여")
public class CoordinateTest {

    @ParameterizedTest
    @DisplayName("정상적으로 자르는가")
    @MethodSource("parameter.TestParameter#numbersProvider")
    public void processTest(String string, Coordinate result) {
        assertTrue(new Coordinate(string).equals(result));
    }

    @ParameterizedTest
    @DisplayName("범위 외의 수가 입력되면 예외를 던지는가")
    @ValueSource(strings = {"(0,2)", "(1,25)"})
    public void processCheckExceptionTest(String string) {
        assertThrows(OutOfRangeException.class, () -> new Coordinate(string));
    }
}
