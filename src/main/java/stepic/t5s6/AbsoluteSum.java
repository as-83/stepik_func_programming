package stepic.t5s6;

import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;
import java.util.stream.Collectors;

class AbsoluteSum {

    public static long sumOfAbsoluteNumbers(Collection<Long> numbers) {
        return numbers.stream().reduce(0L, (a, b) -> a + Math.abs(b));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Collection<Long> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Long::parseLong)
                .collect(Collectors.toList());

        System.out.println(sumOfAbsoluteNumbers(numbers));
    }
}
