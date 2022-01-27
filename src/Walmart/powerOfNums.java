package Walmart;
import java.util.*;

// https://practice.geeksforgeeks.org/problems/power-of-numbers-1587115620/1/?company[]=Walmart&company[]=Walmart&page=1&query=company[]Walmartpage1company[]Walmart
public class powerOfNums {
    public static void main(String[] args) {
        int N = 12, R = 21;

        System.out.println(power(N, R));
    }

    private static long power(long n, long r) {
        final long MOD = 1000000000 + 7;
        long ans = 1;

        n = n % MOD;
        if(n == 0) {
            return 0;
        }

        while (r > 0) {
            if((r & 1) != 0) {
                ans = (ans * n) % MOD;
            }

            r = r >> 1;
            n = (n * n) % MOD;
        }

        return ans;
    }
}
