package Walmart;
import java.util.*;

// https://leetcode.com/problems/remove-colored-pieces-if-both-neighbors-are-the-same-color/
public class removeColorPieces {
    // TC: O(n) ; SC: O(1)
    public static void main(String[] args) {
        String colors = "AAABABB";
        System.out.println(winnerOfGame(colors));
    }

    private static boolean winnerOfGame(String colors) {
        int countA = 0, countB = 0;
        int mA = 0, mB = 0;

        for(int i=0; i < colors.length(); i++) {

            if(colors.charAt(i) == 'A') {

                countB = 0;
                if(++countA > 2) {
                    mA++;
                }
            }

            else {

                countA = 0;
                if(++countB > 2) {
                    mB++;
                }
            }
        }
        return mA > mB;
    }
}
