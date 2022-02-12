package stepic.t6s3;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

class PrimeNumberGenerator {

    public static void main(String[] args) {
        createPrimesFilteringStream(0,1000).forEach(System.out::println);
    }

    public static LongStream createPrimesFilteringStream(long start, long end) {
        // write your code here
        List<Long> longList = Stream.iterate(start, i -> i + 1).limit(end + 1).collect(Collectors.toList());
        return longList.parallelStream().mapToLong(Long::longValue).filter(NumberUtils::isPrime);
    }

    static class NumberUtils {
        public static boolean isPrime(long n) {
            return n > 1 && LongStream
                    .rangeClosed(2, n - 1)
                    .noneMatch(divisor -> n % divisor == 0);
        }
    }

}
