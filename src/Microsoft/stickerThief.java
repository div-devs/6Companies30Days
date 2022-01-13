package Microsoft;
import java.util.*;

// https://practice.geeksforgeeks.org/problems/stickler-theif-1587115621/1/
public class stickerThief {
    public static void main(String[] args) {
        int n = 6;
        int[] a = {5,5,10,100,10,5};

        System.out.println(FindMaxSum(a, n));
    }

    public static int FindMaxSum(int[] arr, int n) {

        int[] dp = new int[arr.length + 2];

        dp[0] = 0;
        dp[1] = 0;

        for (int i = 0; i < n; i++) {

            dp[i + 2] = Math.max(arr[i] + dp[i], dp[i + 1]);
        }
        return dp[dp.length - 1];
    }
}
