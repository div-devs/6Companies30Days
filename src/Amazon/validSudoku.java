package Amazon;

// https://practice.geeksforgeeks.org/problems/is-sudoku-valid4820/1/
public class validSudoku {
    public static void main(String[] args) {
        int[][] mat = {
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };

        System.out.println(isValid(mat));
    }

    private static int isValid(int[][] mat){
        boolean flag = true;
        for (int i = 0; i < 9; i++) {
            if (!isValidRow(mat, i) || !isValidColumn(mat, i)) {
                flag = false;
                break;
            }
        }

        for (int i = 0; i < 9; i+=3) {
            for (int j = 0; j < 9; j+=3) {
                flag = flag & isValidSubgrid(mat, i, j);
            }
        }

        return flag ? 1 : 0;
    }

    private static boolean isValidSubgrid(int[][] mat, int a, int b) {
        int[] freq = new int[10];

        for (int i = a; i < a + 3; i++) {
            for (int j = b; j < b + 3; j++) {
                freq[mat[i][j]]++;
            }
        }

        for (int i = 1; i <= 9; i++) {
            if (freq[i] > 1) {
                return false;
            }
        }

        return true;
    }

    private static boolean isValidRow(int[][] mat, int rowIndex) {

        int[] freq = new int[10];
        for (int i = 0; i < 9; i++)
            freq[mat[rowIndex][i]]++;

        for (int i = 1; i <= 9; i++) {
            if (freq[i] > 1) {
                return false;
            }
        }

        return true;
    }

    private static boolean isValidColumn(int[][] mat, int columnIndex) {

        int[] freq = new int[10];
        for (int i = 0; i < 9; i++)
            freq[mat[i][columnIndex]]++;

        for (int i = 1; i <= 9; i++) {
            if (freq[i] > 1) {
                return false;
            }
        }

        return true;
    }
}
