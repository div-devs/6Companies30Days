package GoldmanSachs;

import java.util.*;
// https://practice.geeksforgeeks.org/problems/number-following-a-pattern3126/1
public class numFollowingAPattern {
    public static void main(String[] args) {
        String s = "IIDDD";
        System.out.println(printMinNumberForPattern(s));
    }

    private static String printMinNumberForPattern(String s) {
        Stack<Integer> st = new Stack<>();
        StringBuilder ans = new StringBuilder();
        int num = 1;

        st.push(num);
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if( c == 'D' ){
                st.push( ++num );
            }
            else {
                while( st.size() > 0 ){
                    ans.append(st.pop());
                }

                st.push( ++num );
            }
        }

        while(st.size() > 0) {
            ans.append(st.pop());
        }

        return ans.toString();
    }
}
