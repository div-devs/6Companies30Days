package Intuit;
import java.util.*;

// https://practice.geeksforgeeks.org/problems/largest-number-in-k-swaps-1587115620/1#
public class largestNumInKSwaps {
    public static void main(String[] args) {
        int K = 4;
        String str = "1234567";

        System.out.println(findMaximumNum(str, K));
    }

    static String ans = "";
    private static String findMaximumNum(String str, int k) {
        ans = str;
        maxima(str.toCharArray(), k,0);

        return ans;
    }

    private static void maxima(char[] str, int k, int idx) {
        if(k == 0 || idx == str.length) {
            String sp = new String(str);
            if(ans.compareTo(sp) < 0) {
                ans = sp;
            }
            return;
        }
        char max = str[idx];
        for(int i = idx + 1; i < str.length; i++) {
            if(str[i] > max) {
                max = str[i];
            }
        }
        if(max != str[idx]) {
            k--;
        }
        for(int i = idx; i <= str.length - 1; i++) {
            if(str[i] == max) {
                swap(str, idx, i);
                maxima(str, k, idx+1);
                swap(str, i, idx);
            }
        }
    }
    private static void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

}
