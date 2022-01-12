package Microsoft;
import java.util.*;

// https://practice.geeksforgeeks.org/problems/stock-span-problem-1587115621/1
public class stockSpan {
    public static void main(String[] args) {
        int N = 7;
        int[] price = {100, 80, 60, 70, 60, 75, 85};

        System.out.println(Arrays.toString(calculateSpan(price, N)));
    }

    public static int[] calculateSpan(int[] price, int n) {

        int[] result = new int[n];

        result[0] = 1;

        for (int i = 1; i < n; i++) {
            result[i] = 1;

            for (int j = i - 1; j >= 0; j -= result[j]) {
                if (price[j] > price[i]) {
                    break;
                }
                result[i] += result[j];
            }
        }

        return result;
    }

}
