package Intuit;
import java.util.*;

// https://leetcode.com/problems/split-array-largest-sum/
public class splitArrayLargestSum {
    public static void main(String[] args) {
        int m = 2;
        int[] nums = {7,2,5,10,8};

        System.out.println(splitArray(nums, m));
    }

    private static int splitArray(int[] nums, int m) {
        int start = 0;
        int end = nums.length;

        for (int j : nums) {
            start = Math.max(start, j);
            end += j;
        }

        while(start < end) {

            int mid = start + (end - start) / 2;

            int sum = 0;
            int pieces = 1;

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
