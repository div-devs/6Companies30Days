package Walmart;
import java.util.*;

// https://leetcode.com/problems/generate-random-point-in-a-circle/
public class randomPointCircle {
    double rad, x_axis, y_axis;
    public Solution(double radius, double x_center, double y_center) {
        rad = radius;
        x_axis = x_center;
        y_axis = y_center;
    }

    public double[] randPoint() {
        double ang = Math.random() * 2 * Math.PI,
                hyp = Math.sqrt(Math.random()) * rad,
                adj = Math.cos(ang) * hyp,
                opp = Math.sin(ang) * hyp;

        double[] ans = {x_axis + adj, y_axis + opp};
        return ans;
    }
}
