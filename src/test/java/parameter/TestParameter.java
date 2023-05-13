package parameter;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

import org.junit.jupiter.params.provider.Arguments;

import domain.Coordinate;

public class TestParameter {
    private static Stream<Arguments> numbersProvider() {
        return Stream.of(
            Arguments.of("(1,2)", Collections.singletonList(new Coordinate(Arrays.asList(1, 2)))),
            Arguments.of("(24,1)",  Collections.singletonList(new Coordinate(Arrays.asList(24, 1)))),
            Arguments.of("(13,22)",  Collections.singletonList(new Coordinate(Arrays.asList(13, 22))))
        ).map(arguments -> Arguments.of(arguments.get()[0], arguments.get()[1]));
    }

    private static Stream<Arguments> lineProvider() {
        return Stream.of(
            Arguments.of(Arrays.asList(new Coordinate(Arrays.asList(1, 2)), new Coordinate(Arrays.asList(1, 3))), 1.0),
            Arguments.of(Arrays.asList(new Coordinate(Arrays.asList(10, 10)), new Coordinate(Arrays.asList(20, 20))),
                14.142135),
            Arguments.of(Arrays.asList(new Coordinate(Arrays.asList(10, 5)), new Coordinate(Arrays.asList(20, 10))),
                11.180339)
        ).map(arguments -> Arguments.of(arguments.get()[0], arguments.get()[1]));
    }

    private static Stream<Arguments> triangleProvider() {
        return Stream.of(
            Arguments.of(Arrays.asList(new Coordinate(Arrays.asList(20, 1)), new Coordinate(Arrays.asList(20, 5)),
                new Coordinate(Arrays.asList(10, 5))), 20),
            Arguments.of(Arrays.asList(new Coordinate(Arrays.asList(10, 10)), new Coordinate(Arrays.asList(20, 15)),
                new Coordinate(Arrays.asList(15, 15))), 12.5002),
            Arguments.of(Arrays.asList(new Coordinate(Arrays.asList(5, 5)), new Coordinate(Arrays.asList(10, 10)),
                new Coordinate(Arrays.asList(5, 10))), 12.5)
        ).map(arguments -> Arguments.of(arguments.get()[0], arguments.get()[1]));
    }

    private static Stream<Arguments> rectangleProvider() {
        return Stream.of(
            Arguments.of(Arrays.asList(new Coordinate(Arrays.asList(1, 2)), new Coordinate(Arrays.asList(1, 3)),
                new Coordinate(Arrays.asList(3, 2)), new Coordinate(Arrays.asList(3, 3))
            ), 2.0),
            Arguments.of(Arrays.asList(new Coordinate(Arrays.asList(10, 1)), new Coordinate(Arrays.asList(20, 11)),
                new Coordinate(Arrays.asList(20, 1)), new Coordinate(Arrays.asList(10, 11))
            ), 100.0),
            Arguments.of(Arrays.asList(new Coordinate(Arrays.asList(5, 5)), new Coordinate(Arrays.asList(10, 10)),
                new Coordinate(Arrays.asList(5, 10)), new Coordinate(Arrays.asList(10, 5))
            ), 25.0)
        ).map(arguments -> Arguments.of(arguments.get()[0], arguments.get()[1]));
    }
}
