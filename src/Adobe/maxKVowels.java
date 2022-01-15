package Adobe;
import java.util.*;

// https://practice.geeksforgeeks.org/problems/7b9d245852bd8caf8a27d6d3961429f0a2b245f1/1/
public class maxKVowels {
    public static void main(String[] args) {
        int N = 1, K = 0;
        System.out.println(kvowelwords(N, K));
    }

    private static int kvowelwords(int N, int K) {
        final int MOD = 1000000007;
        int sum = 1;

        int[][] dp = new int[N + 1][K + 1] ;
        for(int i = 1; i <= N; i++) {
            dp[i][0] = sum * 21;
            dp[i][0] %= MOD;

            sum = dp[i][0];

            for(int j = 1; j <= K; j++) {

                if (j > i) {
                    dp[i][j] = 0;
                }
                else if (j == i) {
                    dp[i][j] = fastPower(5, i, MOD);
                }

                else {
                    dp[i][j] = dp[i - 1][j - 1] * 5;
                }

                dp[i][j] %= MOD;

                sum += dp[i][j];
                sum %= MOD;
            }
        }
        return sum;
    }

    private static int fastPower(int x, int y, int mod) {
        int res = 1;
        x = x % mod;

        if (x == 0) {
            return 0;
        }

        while (y > 0) {
            if ((y & 1) != 0)
                res = (res * x) % mod;

            y = y >> 1;
            x = (x * x) % mod;
        }
        return res;
    }
}
