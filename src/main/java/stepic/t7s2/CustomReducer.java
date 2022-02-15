package stepic.t7s2;

import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.IntBinaryOperator;
import java.util.function.ToIntBiFunction;
import java.util.stream.*;

class CustomReducer {

    /**
     * The operator combines all values in the given range into one value
     * using combiner and initial value (seed)
     */
    public static final BiFunction<Integer, IntBinaryOperator, IntBinaryOperator> reduceIntOperator =
            (i, operator) -> (x, y) -> {
                int result = i;
                for (int j = x; j <= y; j++) {
                    result = operator.applyAsInt(result, j);
                }
                return result;
            };

    public static final BiFunction<Integer, IntBinaryOperator, IntBinaryOperator> reduceIntOperator2 =
            (s, operator) -> (x, y) -> IntStream.iterate(x, i -> i <= y, i -> i + 1)
            .reduce(s, operator::applyAsInt);

    /**
     * The operator calculates the sum in the given range (inclusively)
     */
    public static final IntBinaryOperator sumOperator = reduceIntOperator.apply(0, (x, y) -> x + y);

    /**
     * The operator calculates the product in the given range (inclusively)
     */
    public static final IntBinaryOperator productOperator = reduceIntOperator.apply(1, (x, y) -> x * y);
   // write your code here

    // Don't change the code below
    public static void main(String[] args) {

        /*Scanner scanner = new Scanner(System.in);
        String[] values = scanner.nextLine().split(" ");*/
        String[] values = "1 5".split(" ");

        int l = Integer.parseInt(values[0]);
        int r = Integer.parseInt(values[1]);

        int sumReducer = reduceIntOperator.apply(0, Integer::sum).applyAsInt(l, r);
        int sum = sumOperator.applyAsInt(l, r);

        int prodReducer = reduceIntOperator.apply(1, (x, y) -> x * y).applyAsInt(l, r);
        int prod = productOperator.applyAsInt(l, r);

        System.out.println(String.format("%d %d %d %d", sumReducer, sum, prodReducer, prod));

        IntBinaryOperator sum2 = (x, y) -> x * y;
        IntBinaryOperator resultWithSumOperator = reduceIntOperator.apply(5, sum2);
          // 15 = 5 + (1 + 2 + 3 + 4)
        System.out.println(resultWithSumOperator.applyAsInt(1, 4));

       sum2 = (x, y) -> x * y;
        resultWithSumOperator = reduceIntOperator.apply(5, sum2);

        System.out.println(resultWithSumOperator.applyAsInt(1, 4));


        resultWithSumOperator = reduceIntOperator2.apply(5, sum2);

        System.out.println(resultWithSumOperator.applyAsInt(1, 4));

    }
}
