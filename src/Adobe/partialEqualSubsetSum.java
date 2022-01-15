package Adobe;
import java.util.*;

// https://practice.geeksforgeeks.org/problems/subset-sum-problem2014/1
public class partialEqualSubsetSum {
    public static void main(String[] args) {
        int N = 4;
        int[] arr = {1, 5, 11, 5};

        System.out.println(equalPartition(N, arr));
    }

    private static boolean equalPartition(int N, int[] arr) {
        int sum = 0;

        for(int i = 0; i < N; i++) {
            sum += arr[i];
        }
        if(sum % 2 != 0){
            return false;
        }
        boolean[][] dp = new boolean[N+1][sum+1];
        for(int i = 0; i <= sum; i++) {
            dp[0][i] = false;
        }

        for(int i = 0; i <= N; i++) {
            dp[i][0] = true;
        }

        for(int i = 1; i <= N; i++) {

            for(int j = 1; j <= sum; j++) {

                if(arr[i-1] <= j) {

                    dp[i][j] = (dp[i - 1][j] || dp[i - 1][j - arr[i - 1]]);
                }

                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[N][sum / 2];
    }
}
