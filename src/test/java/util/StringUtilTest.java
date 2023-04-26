package util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("문자열을")
public class StringUtilTest {

	@ParameterizedTest
	@DisplayName("정상적으로 자르는가")
	@MethodSource("splitTestProvider")
	public void splitTest(String string, List<Integer> result){
		assertEquals(StringUtil.split(string), result);
	}


	private static Stream<Arguments> splitTestProvider() {
		return Stream.of(
			Arguments.of("1,2", Arrays.asList(1, 2)),
			Arguments.of("24,1", Arrays.asList(24, 1)),
			Arguments.of("13,22", Arrays.asList(13, 22))
		).map(arguments -> Arguments.of(arguments.get()[0], arguments.get()[1]));
	}
}
