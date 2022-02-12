package stepic.javabasecourse.t2s3;

import java.math.BigInteger;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(factorial(5).toString());
    }

    public static boolean isPalindrome(String text) {
        text = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        System.out.println(text);
        StringBuilder stringBuilder = new StringBuilder(text);
        stringBuilder.reverse();

        return stringBuilder.toString().equals(text);
    }

    public static BigInteger factorial(int value) {
        BigInteger bigInteger = BigInteger.valueOf(value);
        bigInteger =  bigInteger.multiply(factorial(BigInteger.valueOf(value -1)));
        return bigInteger; // your implementation here
    }

    private static BigInteger factorial(BigInteger valueOf) {
        return valueOf.compareTo(BigInteger.ONE) == 0 ? BigInteger.ONE :
                valueOf.multiply(factorial(valueOf.subtract(BigInteger.ONE)));
    }

    /**
     * Merges two given sorted arrays into one
     *
     * @param a1 first sorted array
     * @param a2 second sorted array
     * @return new array containing all elements from a1 and a2, sorted
     */
    public static int[] mergeArrays(int[] a1, int[] a2) {
        int[] mergedArray = new int[a1.length + a2.length];
        int a1index = 0;
        int a2index = 0;
        for (int i = 0; i < mergedArray.length; i++) {
            int valueToPut = 0;
            if (a1index < a1.length && a2index < a2.length) {
                    if(a1[a1index] < a2[a2index]) {
                        valueToPut = a1[a1index++];
                    } else {
                        valueToPut = a2[a2index++];
                    }
            } else if (a1index < a1.length ) {
                valueToPut = a1[a1index++];
            }  else if (a2index < a2.length ) {
                valueToPut = a2[a2index++];
            }
            mergedArray[i] = valueToPut;
        }
        return mergedArray;
    }


}
