package util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("문자열을")
public class StringUtilTest {
	@Test
	@DisplayName("정상적으로 자르는가")
	@MethodSource("splitProvider")
	public void split(){
		assertEquals(StringUtil.split("1,2"), "1,2".split(","));
	}


	private static Stream<Arguments> splitProvider() {
		return Stream.of(
			Arguments.of("1,2", Arrays.asList("1", "2")),
			Arguments.of("24,1", Arrays.asList("24", "1")),
			Arguments.of("13,22", Arrays.asList("13", "22"))
		);
	}
}
