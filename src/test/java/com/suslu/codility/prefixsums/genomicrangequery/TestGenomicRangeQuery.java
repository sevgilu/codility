package com.suslu.codility.prefixsums.genomicrangequery;

import com.suslu.codility.exception.InvalidInputException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public abstract class TestGenomicRangeQuery {
    private final GenomicRangeQuery genomicRangeQuery;

    public TestGenomicRangeQuery(GenomicRangeQuery genomicRangeQuery) {
        this.genomicRangeQuery = genomicRangeQuery;
    }
    @ParameterizedTest
    @MethodSource("exceptionData")
    public void shouldThrowException(String S, int[] P, int[] Q) {
        Assertions.assertThrows(InvalidInputException.class, () -> genomicRangeQuery.findMinimalImpacts(S, P, Q));
    }
    private static Stream<Arguments> exceptionData() {
        return Stream.of(
                Arguments.of(null, new int[1], new int[1]),
                Arguments.of("", new int[1], new int[1]),
                Arguments.of(" ", new int[1], new int[1]),
                Arguments.of("ACGTK", new int[1], new int[1]),
                Arguments.of("aTCAG", new int[1], new int[1]),

                Arguments.of("ATCG", null, new int[1]),
                Arguments.of("ATCG", new int[0], new int[1]),
                Arguments.of("ATCG", new int[50001], new int[1]),
                Arguments.of("ATCG", new int[1], null),
                Arguments.of("ATCG", new int[1], new int[0]),
                Arguments.of("ATCG", new int[1], new int[50001]),

                Arguments.of("ATCG", new int[]{1,2}, new int[]{1,2,3}),
                Arguments.of("ATCG", new int[]{1,2,2,1}, new int[]{1,2,3}),
                Arguments.of("ATCG", new int[]{1,2,3}, new int[]{1,2,1}),
                Arguments.of("ATCG", new int[]{1,2,3}, new int[]{1,2,4})
        );
    }

    @ParameterizedTest
    @MethodSource("successData")
    public void shouldFindMinimalImpacts(String S, int[] P, int[] Q, List<Integer> expected) {
        List<Integer> actualAsList = Arrays.stream(
                genomicRangeQuery.findMinimalImpacts(S, P, Q))
                .boxed()
                .toList();
        Assertions.assertEquals(expected.toString(), actualAsList.toString());
    }
    private static Stream<Arguments> successData() {
        return Stream.of(
                Arguments.of("ACGT",  new int[]{0,1,2,3},  new int[]{0,1,2,3}, Arrays.asList(1,2,3,4)),
                Arguments.of("ACGT",  new int[]{0,1,2,3},  new int[]{3,3,3,3}, Arrays.asList(1,2,3,4)),
                Arguments.of("CAGCCTA",  new int[]{2,5,0},  new int[]{4,5,6}, Arrays.asList(2,4,1))
        );
    }
}
