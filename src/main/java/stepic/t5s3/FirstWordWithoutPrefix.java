package stepic.t5s3;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class FirstWordWithoutPrefix {

    public static void printFirstWordWithoutPrefix(List<String> words, String prefix) {
        System.out.println(words.stream().filter(w -> !w.startsWith(prefix)).findFirst().orElseGet(() -> ""));
    }

    public static List<String> reduceSuspects(List<String> suspects) {
        return suspects.stream().filter(s -> s.contains("jo")).sorted()
                .collect(Collectors.toList()); // write your code here
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> words = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String prefix = scanner.nextLine();

        printFirstWordWithoutPrefix(words, prefix);

    }
}
