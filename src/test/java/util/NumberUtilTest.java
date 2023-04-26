package util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("숫자에 대하여")
public class NumberUtilTest {

	@ParameterizedTest
	@DisplayName("정상적으로 자르는가")
	@MethodSource("NumbersProvider")
	public void processTest(String string, List<Integer> result){
		assertEquals(NumberUtil.process(string), result);
	}

	@ParameterizedTest
	@DisplayName("범위 외의 수가 입력되면 예외를 던지는가")
	@ValueSource(strings = {"(0,2)", "(1,25)"})
	public void processCheckExceptionTest(String string) {
		assertThrows(OutOfRangeException.class, () -> NumberUtil.process(string));
	}


	private static Stream<Arguments> NumbersProvider() {
		return Stream.of(
			Arguments.of("(1,2)", Arrays.asList(1, 2)),
			Arguments.of("(24,1)", Arrays.asList(24, 1)),
			Arguments.of("(13,22)", Arrays.asList(13, 22))
		).map(arguments -> Arguments.of(arguments.get()[0], arguments.get()[1]));
	}
}
