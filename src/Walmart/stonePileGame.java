package Walmart;
import java.util.*;

// https://leetcode.com/problems/stone-game/
public class stonePileGame {
    // TC: O(n^2) ; SC: O(n^2)
    public static void main(String[] args) {
        int[] piles = {5,3,4,5};

        System.out.println(stoneGame(piles));
    }

    private static boolean stoneGame(int[] piles) {
        int n = piles.length;

        int[][] dp = new int[n+2][n+2];

        for (int size = 1; size <= n; ++size) {
            for (int i = 0; i + size <= n; ++i) {

                int j = i + size - 1;

                int parity = (j + i + n) % 2;
                if (parity == 1) {
                    dp[i + 1][j + 1] = Math.max(piles[i] + dp[i + 2][j + 1], piles[j] + dp[i + 1][j]);
                }
                else {
                    dp[i + 1][j + 1] = Math.min(-piles[i] + dp[i + 2][j + 1], -piles[j] + dp[i + 1][j]);
                }
            }
        }

        return dp[1][n] > 0;
    }
}
