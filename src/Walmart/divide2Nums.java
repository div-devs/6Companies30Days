package Walmart;
import java.util.*;

// https://leetcode.com/problems/divide-two-integers/
public class divide2Nums {
    public static void main(String[] args) {
        int dividend = 10, divisor = 3;

        System.out.println(divide(dividend, divisor));
    }

    private static int divide(int dividend, int divisor) {
        boolean isNeg = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);

        long ldividend = Math.abs((long)dividend);
        long ldivisor = Math.abs((long)divisor);

        long res = 0, curr = 1;
        long sub = ldivisor;

        while (ldividend >= ldivisor) {

            if (ldividend >= sub) {

                res += curr;
                ldividend -= sub;
                sub = sub << 1;
                curr = curr << 1;
            }

            else {
                sub = sub >> 1;
                curr = curr >> 1;
            }
        }

        res = isNeg ? -res : res;

        return (int) (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE ? Integer.MAX_VALUE : res);
    }
}
