package GoldmanSachs;
import java.util.*;

// https://practice.geeksforgeeks.org/problems/print-anagrams-together/1/#
public class groupAnagramsStrings {
    public static void main(String[] args) {
        String[] words = {"no","on","is"};
        System.out.println(groupAnagrams(words));
    }

    public static List<List<String>> groupAnagrams(String[] str) {
        if(str.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List> ans = new HashMap<>();
        for(String s : str) {
            char[] c = s.toCharArray();
            Arrays.sort(c);

            String k = String.valueOf(c);
            if(!ans.containsKey(k)) {
                ans.put(k, new ArrayList<>());
            }

            ans.get(k).add(s);
        }

        return new ArrayList(ans.values());
    }
}
