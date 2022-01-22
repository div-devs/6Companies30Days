package Intuit;
import java.util.*;

// https://leetcode.com/problems/course-schedule-ii/
public class courseSchedule2 {
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1,0}};

        System.out.println(Arrays.toString(findOrder(numCourses, prerequisites)));
    }

    private static int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0 || prerequisites == null) {
            return new int[0];
        }

        Map<Integer, List<Integer>> map = buildMap(numCourses, prerequisites);
        Map<Integer, Integer> indegree = buildIndegree(numCourses, map);
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree.get(i) == 0) {
                queue.offer(i);
            }
        }
        int[] ans = new int[numCourses];
        int idx = 0;
        while (!queue.isEmpty()) {

            int node = queue.poll();
            ans[idx++] = node;

            for (int next : map.get(node)) {
                indegree.put(next, indegree.get(next) - 1);

                if (indegree.get(next) == 0) {
                    queue.offer(next);
                }
            }
        }

        return idx == numCourses ? ans : new int[0];
    }

    private static Map<Integer, List<Integer>> buildMap(int n, int[][] prereq) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] pre : prereq) {
            map.get(pre[1]).add(pre[0]);
        }
        return map;
    }

    private static Map<Integer, Integer> buildIndegree(int n, Map<Integer, List<Integer>> map) {

        Map<Integer, Integer> indegree = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indegree.put(i, 0);
        }

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            for (int next : entry.getValue()) {
                indegree.put(next, indegree.get(next) + 1);
            }
        }
        return indegree;
    }
}
