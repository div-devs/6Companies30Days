package GoldmanSachs;

// https://practice.geeksforgeeks.org/problems/squares-in-nn-chessboard1801/1
public class squareCountinNbyNChessBoard {
    public static void main(String[] args) {
        long n = 2;
        System.out.println(squaresInChessBoard(n));
    }

    private static Long squaresInChessBoard(Long n) {
        long res = 0;
        while(n>=1) {
            res = res + (n*n);
            n--;
        }
        return res;
    }
}
