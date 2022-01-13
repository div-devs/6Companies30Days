package Microsoft;
import java.util.*;

// https://practice.geeksforgeeks.org/problems/length-of-largest-region-of-1s-1587115620/1/
public class unitAreaFrom1s {
    public static void main(String[] args) {
        int[][] grid = {{1,1,1,0},{0,0,1,0},{0,0,0,1}};
        System.out.println(findMaxArea(grid));
    }

    public static int findMaxArea(int[][] grid) {
        int max = 0;
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];
        int area;
        for(int i = 0; i < n; i++) {

            for(int j = 0; j < grid[i].length; j++) {

                if(grid[i][j]==1 && !visited[i][j]) {

                    area= helper(grid, i, j, visited);
                    if(area > max) {
                        max = area;
                    }
                }
            }
        }
        return max;
    }

    public static int helper(int[][] grid, int i, int j, boolean[][] visited) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0 || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;

        return (helper(grid,i+1,j,visited) +
                helper(grid,i-1,j,visited) +
                helper(grid,i,j+1,visited) +
                helper(grid,i,j-1,visited) +
                helper(grid,i+1,j-1,visited) +
                helper(grid,i-1,j+1,visited) +
                helper(grid,i+1,j+1,visited) +
                helper(grid,i-1,j-1,visited)+1);
    }
}
