package Amazon;

// https://practice.geeksforgeeks.org/problems/maximum-profit4657/1
public class maximumProfit {
    public static void main(String[] args) {
        int K = 2, N = 6;
        int[] A = {10, 22, 5, 75, 65, 80};

        System.out.println(maxProfit(K, N, A));
    }

    private static int maxProfit(int K, int n, int[] A) {
        int[][] dp = new int[K+1][n];
        for(int i=0;i<=K;i++)
        {
            dp[i][0]=0;
        }
        for(int i=0;i<n;i++) {
            dp[0][i]=0;
        }
        for(int i=1;i<=K;i++)
        {
            int prevProfit=Integer.MIN_VALUE;
            for(int j=1;j<n;j++) {
                prevProfit= Math.max(prevProfit,dp[i-1][j-1]-A[j-1]);
                dp[i][j]=Math.max(dp[i][j-1],prevProfit+A[j]);
            }
        }
        return dp[K][n-1];
    }
}
