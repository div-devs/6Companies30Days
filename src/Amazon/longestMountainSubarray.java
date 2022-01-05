package Amazon;

// https://leetcode.com/problems/longest-mountain-in-array/
// TC: O(N) ; SC: O(1)
public class longestMountainSubarray {
    public static void main(String[] args) {
        int[] arr = {2,1,4,7,3,2,5};
        System.out.println(longestMountain(arr));
    }

    public static int longestMountain(int[] arr) {

        int maxLen = 0;
        int i = 0;
        int j = 0;
        boolean incr = false;
        boolean decr = false;

        while(i < arr.length - 2) {

            while(i < arr.length - 1 && arr[i] >= arr[i + 1]) {
                i++;
            }
            incr = false;
            decr = false;


            j = i;
            while(j < arr.length - 1 && arr[j] < arr[j + 1]) {
                incr = true;
                j++;
            }


            while(j < arr.length - 1 && arr[j] > arr[j + 1]) {
                decr = true;
                j++;
            }

            if(incr && decr) {
                maxLen = Math.max(maxLen, j - i + 1);
            }

            i = j;
        }

        if(incr && decr) {
            maxLen = Math.max(maxLen, j - i + 1);
        }

        return maxLen >= 3 ? maxLen : 0;
    }
}
