package Walmart;
import java.util.*;

// https://leetcode.com/problems/find-the-kth-largest-integer-in-the-array/
public class kLargestNumInArray {
    // TC: O(nlogn) ; SC: O(n)
    public static void main(String[] args) {
        String[] nums = {"3","6","7","10"};
        int k = 4;

        System.out.println(kthLargestNumber(nums, k));
    }

    private static String kthLargestNumber(String[] nums, int k) {
        Queue<String> q = new PriorityQueue<>( (val1, val2) -> {
            if(val1.length() == val2.length()) {
                return val2.compareTo(val1);
            }

            return val2.length() - val1.length();
        });

        for(String num : nums) {
            q.offer(num);
        }

        String ans = null;

        for(int i = 0; i < k; i++) {
            ans = q.poll();
        }
        return ans;
    }
}
