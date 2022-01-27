package Walmart;
import java.util.*;

// https://practice.geeksforgeeks.org/problems/sorted-subsequence-of-size-3/1/
public class threeSizeSortedSubsequence {
    public static void main(String[] args) {
        int N = 3;
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(1);
        arr.add(3);
        System.out.println(find3Numbers(arr, N));
    }

    private static int find3Numbers(ArrayList<Integer> arr, int n) {
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i = n - 1; i >= 0; i--) {

            while(!st.isEmpty() && st.peek()<=arr.get(i)) {
                st.pop();
            }

            st.push(arr.get(i));

            if(st.size() == 3) {
                break;
            }
        }

        if(st.size() >= 3) {
            for(int i = 2; i >= 0; i--) {
                ans.add(st.pop());
            }
        }
        return ans.size();
    }
}
