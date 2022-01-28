package Walmart;
import java.util.*;

// https://practice.geeksforgeeks.org/problems/largest-number-in-k-swaps-1587115620/1/
public class largestNumInKSwaps {
    public static void main(String[] args) {
        int K = 4;
        String str = "1234567";

        System.out.println(findMaximumNum(str, K));
    }

    private static String findMaximumNum(String s, int k) {
        max = Long.parseLong(s);
        helper(s,k);

        return Long.toString(max);
    }

    static long max;

    private static void helper(String s, int k){
        int n = s.length();
        max = Math.max(Long.parseLong(s), max);
        if(k == 0) {
            return;
        }

        for(int i = 0;i < n - 1; i++) {
            for(int j = i + 1; j < n; j++) {
                if(s.charAt(j) > s.charAt(i)) {

                    s = swap(s,i,j);
                    helper(s,k-1);
                    s = swap(s,i,j);
                }
            }
        }
    }

    private static String swap(String s, int i,int j){
        char[] c = s.toCharArray();

        char ch = c[i];
        c[i] = c[j];
        c[j] = ch;

        return String.valueOf(c);
    }
}
