package Microsoft;
import java.util.*;

// https://practice.geeksforgeeks.org/problems/rotate-by-90-degree0356/1/
public class rotateMatrix {
    public static void main(String[] args) {

        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        rotate(matrix);

        for(int[] i : matrix) {
            System.out.println(Arrays.toString(i));
        }
    }

    public static void rotate(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;


        for(int i = 0; i < n; i++) {

            for(int j = i + 1; j < m; j++) {
                int tmp = matrix[i][j];

                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }



        for(int i = 0; i < n/2; i++) {

            for(int j = 0; j < m; j++) {
                int tmp = matrix[i][j];

                matrix[i][j] = matrix[m-i-1][j];
                matrix[m-i-1][j] = tmp;
            }
        }
    }
}
