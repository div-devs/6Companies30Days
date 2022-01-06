package Amazon;

// https://practice.geeksforgeeks.org/problems/brackets-in-matrix-chain-multiplication1024/1/
public class matrixChainMultiplicationBrackets {
    public static void main(String[] args) {
        int n = 5;
        int[] p = {1, 2, 3, 4, 5};
        matrixChainOrder(p, n);
    }

    private static char name;

    private static void matrixChainOrder(int p[], int n)
    {

        int[][] m = new int[n][n];

        int[][] bracket = new int[n][n];

        for (int i = 1; i < n; i++)
            m[i][i] = 0;

        for (int L = 2; L < n; L++)
        {
            for (int i = 1; i < n - L + 1; i++)
            {
                int j = i + L - 1;
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++)
                {
                    int q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (q < m[i][j])
                    {
                        m[i][j] = q;

                        bracket[i][j] = k;
                    }
                }
            }
        }

        name = 'A';

        printParenthesis(1, n - 1, n, bracket);

    }

    private static void printParenthesis(int i, int j, int n, int[][] bracket) {

        if (i == j)
        {
            System.out.print(name++);
            return;
        }
        System.out.print("(");

        printParenthesis(i, bracket[i][j], n, bracket);

        printParenthesis(bracket[i][j] + 1, j, n, bracket);
        System.out.print(")");
    }
}
