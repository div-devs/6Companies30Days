package Amazon;

// https://practice.geeksforgeeks.org/problems/count-ways-to-nth-stairorder-does-not-matter1322/1/
public class waysToNthStairs {
    public static void main(String[] args) {
        int N = 4;
        System.out.println(countWays(N));
    }

    private static long countWays(int n) {
        final long MOD = (int) Math.pow(10,9)+7;

        long[] arr=new long[2];
        int w = n;

        arr[0]=1;
        arr[1]=2;

        n=2;
        long[][] dp=new long[n+1][w+1];

        for(int i=0;i<=n;i++) {
            dp[i][0] = 1;
        }

        for(int i=1;i<=n;i++) {
            for(int j=1;j<=w;j++) {
                if(arr[i-1]<=j) {
                    dp[i][j] = (dp[i][j - (int) arr[i - 1]] + dp[i - 1][j]) % MOD;
                }
                else {
                    dp[i][j] = (dp[i - 1][j]) % MOD;
                }
            }
        }
        return (long)(dp[n][w] % MOD);
    }
}
