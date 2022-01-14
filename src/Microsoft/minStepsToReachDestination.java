package Microsoft;
import java.util.*;

// https://practice.geeksforgeeks.org/problems/minimum-number-of-steps-to-reach-a-given-number5234/1/
public class minStepsToReachDestination {
    public static void main(String[] args) {
        int d = 10;
        System.out.println(minSteps(d));
    }

    public static int minSteps(int D) {
        int steps = 0, sum = 0, target = Math.abs(D);
        while(sum < target || (sum - target) % 2 != 0) {

            steps++;
            sum += steps;
        }
        return steps;

    }
}
