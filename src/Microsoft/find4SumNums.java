package Microsoft;
import java.util.*;

// https://practice.geeksforgeeks.org/problems/find-all-four-sum-numbers1732/1
public class find4SumNums {
    public static void main(String[] args) {
        int N = 5, K = 3;
        int[] A = {0,0,2,1,1};
        System.out.println(fourSum(A, K));
    }

    public static ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
        ArrayList<ArrayList<Integer>> res= new ArrayList<>();
        Arrays.sort(arr);

        int n = arr.length;

        for(int i = 0; i < n - 3; i++) {

            for(int j = i + 1; j < n - 2; j++) {

                int low = j + 1, high = n - 1;

                while(low < high) {

                    int sum = arr[i] + arr[j] + arr[low] + arr[high];
                    if(sum < k) {
                        low++;
                    }
                    else if(sum > k) {
                        high--;
                    }
                    else {

                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(arr[i]);
                        temp.add(arr[j]);
                        temp.add(arr[low]);
                        temp.add(arr[high]);

                        if(!res.contains(temp)) {
                            res.add(temp);
                        }
                        low++;
                        high--;
                    }
                }
            }
        }
        return res;
    }
}
