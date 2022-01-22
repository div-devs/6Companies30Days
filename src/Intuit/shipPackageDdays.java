package Intuit;
import java.util.*;

// https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
public class shipPackageDdays {
    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;

        System.out.println(shipWithinDays(weights, days));
    }

    private static int shipWithinDays(int[] nums, int m) {
        int start = 0;
        int end = 0;

        for (int j : nums) {
            start = Math.max(start, j);
            end += j;
        }

        int pieces = 0;

        while(start < end) {
            int mid = start + (end - start) / 2;

            int sum = 0;
            pieces = 1;

            for(int num : nums) {
                if(sum + num > mid) {

                    sum = num;
                    pieces++;
                }

                else {
                    sum += num;
                }
            }

            if(pieces > m) {
                start = mid + 1;
            }

            else {
                end = mid;
            }
        }

        return start;
    }
}
