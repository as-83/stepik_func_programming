package stepic.t5s6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class CombiningPredicates {

    /**
     * The method represents the conjunction operator for a stream of predicates.
     * For an empty stream it returns the always true predicate.
     */
    public static IntPredicate conjunctAll(Stream<IntPredicate> predicates) {
        return predicates.reduce( (p1, p2) -> p1.and(p2)).orElse(i -> true);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] strings = scanner.nextLine().split("\\s+");

        List<Boolean> values = Arrays.stream(strings)
                .map(Boolean::parseBoolean)
                .collect(Collectors.toList());

        List<IntPredicate> predicates = new ArrayList<>();
        values.forEach(v -> predicates.add(x -> v));

        System.out.println(conjunctAll(predicates.stream()).test(0));
    }
}
