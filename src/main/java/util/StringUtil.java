package util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract class StringUtil {
	private static final int STRING_TRIM_INDEX = 1;
	public static List<Integer> process(String input) {
		input = input.substring(STRING_TRIM_INDEX, input.length() - STRING_TRIM_INDEX);
		List<String> list = Arrays.asList(input.split(","));

		return list.stream()
			.map(Integer::parseInt)
			.collect(Collectors.toList());
	}
}
