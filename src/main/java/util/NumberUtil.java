package util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import exception.OutOfRangeException;

public abstract class NumberUtil {
	private static final int STRING_TRIM_INDEX = 1;
	public static List<Integer> process(String input) {
		input = input.substring(STRING_TRIM_INDEX, input.length() - STRING_TRIM_INDEX);
		List<String> list = Arrays.asList(input.split(","));
		List<Integer> result = list.stream()
			.map(Integer::parseInt)
			.collect(Collectors.toList());
		checkExceptions(result);
		return result;
	}

	private static void checkExceptions(List<Integer> result) {
		if (result.stream().anyMatch(i -> i < 1 || i > 24)) {
			throw new OutOfRangeException(result);
		}
	}
}
