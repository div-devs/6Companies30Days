package Walmart;
import java.util.*;

// https://practice.geeksforgeeks.org/problems/maximum-height-tree4803/1/?page=2&company[]=Walmart&query=page2company[]Walmart
public class heightDotsTree {
    public static void main(String[] args) {
        int N = 10;
        System.out.println(height(N));
    }

    private static int height(int n) {
        int i = 1;
        int temp = 1;
        while(temp <= n) {

            temp += i + 1;
            i += 1;
        }
        return i - 1;
    }
}
