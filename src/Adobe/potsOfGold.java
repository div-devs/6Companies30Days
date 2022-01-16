package Adobe;
import java.util.*;

// https://practice.geeksforgeeks.org/problems/pots-of-gold-game/1/
public class potsOfGold {
    public static void main(String[] args) {
        int N = 4;
        int[] Q = {8, 15, 3, 7};

        System.out.println(maxCoins(Q, N));
    }

    private static int maxCoins(int[] A, int n) {

        int[][] dp = new int[n][n];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return helper(A,0,n-1, dp);
    }

    private static int helper(int[] A, int start, int end, int[][] dp){
        if(start == end) return dp[start][end] = A[start];
        if(start + 1 == end) return dp[start][end] = Math.max(A[start],A[end]);

        if(dp[start][end] != -1) {
            return dp[start][end];
        }
        return dp[start][end] = Math.max(A[start] + Math.min(helper(A,start+2,end,dp),
                helper(A,start+1,end-1,dp)),
                A[end]+Math.min(helper(A,start+1,end-1,dp), helper(A,start,end-2,dp)));
    }
}
