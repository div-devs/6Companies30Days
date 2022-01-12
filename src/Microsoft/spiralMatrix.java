package Microsoft;
import java.util.*;

// https://practice.geeksforgeeks.org/problems/spirally-traversing-a-matrix-1587115621/1/
public class spiralMatrix {
    public static void main(String[] args) {
        int r = 4, c = 4;
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15,16}
            };

        System.out.println(spirallyTraverse(matrix, r, c));
    }

    public static ArrayList<Integer> spirallyTraverse(int[][] matrix, int r, int c) {
        ArrayList<Integer> list = new ArrayList<>();

        int count = 0;
        int i = 0,j = 0,k = 0;
        int l = r - 1;
        int x = 0;

        int area = r * c;
        while(count < area)
        {
            if(j < c - x) {
                list.add(matrix[i][j]);
                j++;
                count++;
            }

            else if(i < r - 1 - x) {
                i++;
                k = j - 1;
                list.add(matrix[i][k]);
                count++;
            }

            else if(k>x) {
                k--;
                list.add(matrix[i][k]);
                count++;
            }

            else if(l > x + 1) {
                l--;
                list.add(matrix[l][k]);
                count++;
            }
            else {
                x++;
                j = x;
                i = x;
                l = r - 1 - x;
            }
        }
        return list;
    }
}
