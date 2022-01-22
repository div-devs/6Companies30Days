package Intuit;
import java.util.*;

// https://leetcode.com/problems/number-of-boomerangs/
public class numBoomerangs {
    public static void main(String[] args) {
        int[][] points = {{0,0},{1,0},{2,0}};

        System.out.println(numberOfBoomerangs(points));
    }

    private static int numberOfBoomerangs(int[][] points) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int boomCount = 0;

        for(int i = 0; i < points.length; i++ ){

            for(int j = 0; j < points.length; j++ ){
                if (i == j) continue;
                int dist = getDist(points[i], points[j]);

                hm.put(dist, hm.getOrDefault(dist,0) + 1);
            }

            for(Integer key: hm.keySet()){
                int size = hm.get(key);
                if(size >= 2) boomCount += size*(size-1);
            }

            hm.clear();
        }

        return boomCount;
    }

    private static int getDist(int[] p1, int[] p2){
        int a = p1[0] - p2[0];
        int b = p1[1] - p2[1];

        return a*a + b*b;
    }
}
