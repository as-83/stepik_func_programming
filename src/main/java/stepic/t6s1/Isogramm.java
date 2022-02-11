package stepic.t6s1;

import java.util.Arrays;
import java.util.Scanner;

class Isogram {

    public static boolean isIsogram(String word) {
        return word.chars().distinct().count() == word.length();
    }

    public static boolean isPowerOfTwo(int value) {

        return Integer.bitCount(Math.abs(value)) == 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine();

        System.out.println(isIsogram(word));
    }
}
