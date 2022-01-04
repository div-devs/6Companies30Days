package GoldmanSachs;

// https://practice.geeksforgeeks.org/problems/find-missing-and-repeating2512/1/
public class findMissingandRepeating {
    public static void main(String[] args) {
        int n = 2;
        int[] arr = {2, 2};
        int[] ans = findTwoElement(arr, n);
        for (int i: ans) {
            System.out.print(i + " ");
        }
    }

    private static int[] findTwoElement(int[] arr, int n) {
        int i=0;
        int[] freq=new int[n+1];
        int[] res=new int[2];

        while(i<=n-1) {
            freq[arr[i]]++;
            i++;
        }
        for(int j = 1;j <= n; j++) {
            if(freq[j] == 2) {
                res[0] = j;
            }
            if(freq[j] == 0) {
                res[1] = j;
            }
        }
        return res;
    }
}
