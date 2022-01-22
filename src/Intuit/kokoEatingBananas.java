package Intuit;
import java.util.*;

// https://leetcode.com/problems/koko-eating-bananas/
public class kokoEatingBananas {
    public static void main(String[] args) {
        int[] piles = {3,6,7,11};
        int h = 8;

        System.out.println(minEatingSpeed(piles, h));
    }

    private static int minEatingSpeed(int[] piles, int h) {
        int s = 1, e = 1;
        for(int pile : piles) {
            e = Math.max(e, pile);
        }

        while(s < e) {
            int m = s + (e - s) / 2;

            int hrs = hoursSpend(piles, m);

            if(hrs <= h) {
                e = m;
            }

            else {
                s = m + 1;
            }
        }

        return e;
    }

    private static int hoursSpend(int[] piles, int speed) {

        int hrSpent = 0;
        for(int pile : piles) {
            hrSpent += Math.ceil((double) pile/speed);
        }

        return hrSpent;
    }
}
