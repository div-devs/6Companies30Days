package Intuit;
import java.util.*;

// https://practice.geeksforgeeks.org/problems/word-search/1/
public class wordSearch {
    public static void main(String[] args) {
        char[][] board = {
                {'a','g','b','c'},
                {'q','e','e','l'},
                {'g','b','k','s'}
        };
        String word = "geeks";

        System.out.println(isWordExist(board, word));
    }

    private static boolean isWordExist(char[][] board, String word) {
        char[] w = word.toCharArray();
        for (int y = 0; y < board.length; y++) {

            for (int x = 0; x < board[y].length; x++) {

                if (exist(0, board, x, y, w)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean exist(int i, char[][] board, int x, int y, char[] word) {
        if (i == word.length) {
            return true;
        }
        if (y<0 || x<0 || y == board.length || x == board[y].length) {
            return false;
        }
        if (board[y][x] != word[i]) {
            return false;
        }
        board[y][x] ^= 256;
        boolean exist = exist(i+1, board, x+1, y, word) ||
                exist(i+1, board, x-1, y, word) ||
                exist(i+1, board, x, y+1, word) ||
                exist(i+1, board, x, y-1, word);

        board[y][x] ^= 256;

        return exist;
    }
}
