package Adobe;
import java.util.*;

// https://practice.geeksforgeeks.org/problems/winner-of-an-election-where-votes-are-represented-as-candidate-names-1587115621/1/
public class electionWinner {
    public static void main(String[] args) {
        int n = 13;
        String[] Votes = {"john","johnny","jackie","johnny","john", "jackie","jamie","jamie","john","johnny","jamie", "johnny","john"};

        System.out.println(Arrays.toString(winner(Votes, n)));
    }

    private static String[] winner(String[] arr, int n) {

        Map<String,Integer> nameVals = new HashMap<>();
        for(String name : arr) {
            if(nameVals.containsKey(name)) {
                nameVals.put(name,nameVals.get(name)+1);
            }

            else {
                nameVals.put(name,1);
            }
        }

        String winner = "";
        int votes = 0;

        for(Map.Entry<String,Integer> entry : nameVals.entrySet()) {
            if(Objects.equals(winner, "")) {
                winner = entry.getKey();
                votes = entry.getValue();
            }

            else if(votes<entry.getValue()) {
                winner = entry.getKey();
                votes = entry.getValue();
            }

            else if(votes == entry.getValue() && winner.compareTo(entry.getKey()) > 0) {
                winner = entry.getKey();
            }
        }

        return new String[]{winner , String.valueOf(votes)};
    }
}
