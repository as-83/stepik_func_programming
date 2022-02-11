package stepic.t5s5;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

class AbsoluteValues {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String result = Arrays.stream(scanner.nextLine().split("\\s+")) // Stream<String>
                .map(Integer::parseInt)
                .map(Math::abs)
                .map(String::valueOf)
                .collect(Collectors.joining(" "));

        System.out.println(result);
    }
}
