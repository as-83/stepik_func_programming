package stepic.t7s2;

import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;

class ExtensionService {

    public static Function<String, String> addExtension(Predicate<String> predicate1, Predicate<String> predicate2) {
        return str -> {
            if (predicate1.test(str)) {
                return str + ".xml";
            } else if (predicate2.test(str)) {
                return str + ".json";
            }
            return str;
        };
    }
    public static void main(String[] args) {
        Function<String, IntFunction<Function<Integer, String>>> sff =
                x -> y -> z -> x + "/" + y + "/" + z;

        IntFunction<Function<Integer, String>> ff = sff.apply("2021");
        Function<Integer, String> f = ff.apply(14);

        System.out.println(ff.apply(12).apply(11));
    }
}
