package util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract class StringUtil {
	public static List<Integer> split(String input) {
		List<String> list = Arrays.asList(input.split(","));

		return list.stream()
			.map(Integer::parseInt)
			.collect(Collectors.toList());
	}
}
