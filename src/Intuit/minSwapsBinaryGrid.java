package Intuit;
import java.util.*;

// https://leetcode.com/problems/minimum-swaps-to-arrange-a-binary-grid/
public class minSwapsBinaryGrid {
    public static void main(String[] args) {
        int[][] grid = {{0,0,1},{1,1,0},{1,0,0}};

        System.out.println(minSwaps(grid));
    }

    private static int minSwaps(int[][] grid)
    {
        int len = grid.length;
        int swap = 0;
        int[] pre = new int[len];

        for(int i = 0; i < len; i++) {
            pre[i] = countRightZeros(grid[i]);
        }

        for(int i = 0; i < len; i++) {

            int minValueRequired = len - i - 1;

            int j = i;
            while(j < len && pre[j] < minValueRequired) {
                j++;
            }

            if(j == len) {
                return -1;
            }

            while(j != i) {
                swap++;

                int temp = pre[j];
                pre[j] = pre[j-1];
                pre[j-1] = temp;
                j--;
            }
        }

        return swap;
    }

    private static int countRightZeros(int[] row) {
        int cnt = 0;

        for(int i = row.length - 1; i >= 0; i--) {
            if(row[i] != 0)
                break;
            cnt++;
        }

        return cnt;
    }


}
