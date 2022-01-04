package GoldmanSachs;

// https://leetcode.com/problems/minimum-size-subarray-sum
// TC: O(n) ; SC: O(n) [2 pointer approach]
public class minimumSizeSubarraySum {
    public static void main(String[] args) {
        int[] arr = {2,3,1,2,4,3};
        int target = 7;

        System.out.println(minSubArrayLen(target, arr));
    }

    private static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;

        int left = 0, sum = 0;

        for (int i = 0; i < n; i++) {

            sum += nums[i];
            while (sum >= target) {

                ans = Math.min(ans, i + 1 - left);
                sum -= nums[left++];
            }
        }
        return (ans != Integer.MAX_VALUE) ? ans : 0;
    }
}
