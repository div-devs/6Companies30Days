package Amazon;
import java.util.*;

// https://practice.geeksforgeeks.org/problems/first-non-repeating-character-in-a-stream1216/1
public class firstNonRepeatingChar {
    public static void main(String[] args) {
        String A = "aabc";
        System.out.println(FirstNonRepeating(A));
    }

    private static String FirstNonRepeating(String A) {
        StringBuilder ans = new StringBuilder();
        int[] isRepeated = new int[26];

        Deque<Character> queue = new ArrayDeque<>();
        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);

            if (isRepeated[ch - 'a'] == 0) {
                queue.add(ch);
            }

            isRepeated[ch - 'a']++;
            while (!queue.isEmpty() && isRepeated[queue.peek() - 'a'] != 1) {
                queue.poll();
            }

            ans.append(queue.isEmpty() ? '#' : queue.peek());
        }
        return  ans.toString();
    }
}
