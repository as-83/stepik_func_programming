package stepic.algodata.s1;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BracketsChecker {
    public static void main(String[] args) {
        ArrayDeque<Character> arrayDeque = new ArrayDeque();
        ArrayDeque<Integer> indexDeque = new ArrayDeque();
        String result = "Success";

        String input = new Scanner(System.in).nextLine();

        if (input.length() == 0) {
            result = "0";
        }

        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            if (current == '(' || current == '[' || current == '{') {
                arrayDeque.push(current);
                indexDeque.push(i);
            } else if (current == ')' || current == ']' || current == '}') {
                if (arrayDeque.isEmpty()) {
                    result = i + 1 + "";
                    break;
                }
                char stackChar = arrayDeque.poll();
                indexDeque.poll();
                boolean correctPare = (current == ')' && stackChar == '(' ) ||
                        (current == ']' && stackChar == '[') ||
                        (current == '}' && stackChar == '{');
                if (!correctPare) {
                    result = i + 1 + "";
                    break;
                }
            }
        }
        if (!arrayDeque.isEmpty()) {
            result = arrayDeque.size() + "";
        }
        System.out.println(result);
    }
}
