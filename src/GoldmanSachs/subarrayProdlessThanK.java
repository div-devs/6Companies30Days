package GoldmanSachs;

// https://practice.geeksforgeeks.org/problems/count-the-subarrays-having-product-less-than-k1708/1/
public class subarrayProdlessThanK {
    public static void main(String[] args) {
        int n = 4, k = 10;
        long[] a = {1, 2, 3, 4};
        // implicit casting of values of int to long

        System.out.println(countSubArrayProductLessThanK(a, n, k));
    }

    private static int countSubArrayProductLessThanK(long a[], long n, long k) {
        // use vector in place of long array, you cannot access all values in long array in java
        // because the iterator in java should be int only
        long prod=1;

        int j = 0;
        int ans = 0;

        for(int i=0;i<n;i++) {

            prod*=a[i];

            while(j<n&&prod>=k) {

                prod/=a[j];
                j++;
            }

            ans+=(i-j+1);

        }
        return ans;
    }
}
