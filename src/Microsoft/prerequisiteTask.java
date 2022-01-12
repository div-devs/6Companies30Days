package Microsoft;
import java.util.*;

// https://practice.geeksforgeeks.org/problems/prerequisite-tasks/1/
public class prerequisiteTask {
    public static void main(String[] args) {
        int N = 4;
        int[][] prerequisites = {{1,0},{2,1},{3,2}};

        if(isPossible(N, prerequisites)) {
            System.out.println(true);
        }

        else {
            System.out.println(false);
        }
    }

    public static boolean isPossible(int N, int[][] prerequisites) {
        Map<Integer, Map<Integer, Integer>> adjList = getAdjacencyList(prerequisites, N);
        LinkedHashSet<Integer> emptyIndices = new LinkedHashSet<>();

        Integer index = getNodeWithoutDependency(adjList, N);
        if (index == -1) {
            return false;
        }
        emptyIndices.add(index);


        while(adjList.size() > 0 && !emptyIndices.isEmpty()) {
            index = emptyIndices.iterator().next();
            emptyIndices.remove(index);
            adjList.remove(index);
            removeFromDependencies(adjList, index, emptyIndices);
        }
        return adjList.size() == 0;
    }

    private static Integer getNodeWithoutDependency(Map<Integer, Map<Integer, Integer>> adjList, int N) {
        for (int i=0; i<N; i++) {
            if (adjList.get(i).isEmpty()) {
                return i;
            }
        }

        return -1;
    }

    private static void removeFromDependencies(
            Map<Integer, Map<Integer, Integer>> adjList,
            Integer val,
            HashSet<Integer> emptyIndices) {
        for (Integer key: adjList.keySet()){
            Map<Integer, Integer> value = adjList.get(key);
            if (value.get(val) != null ) {
                value.remove(val);
            }
            if (adjList.get(key).isEmpty()) {
                emptyIndices.add(key);
            }
        }
    }

    private static Map<Integer, Map<Integer, Integer>> getAdjacencyList(int[][] prerequisites, int N) {
        Map<Integer, Map<Integer, Integer>> adjList = new HashMap<>();
        for (int i=0; i<N; i++) {
            adjList.put(i, new HashMap<>());
        }
        for (int[] pair: prerequisites) {
            int task = pair[0];
            int dependency = pair[1];
            adjList.get(task).put(dependency, dependency);
        }


        return adjList;
    }

}
