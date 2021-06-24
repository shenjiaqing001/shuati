import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/6/24
 */
public class lc1059 {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        boolean[] visited = new boolean[n];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        visited[source] = true;
        for (int[] edge : edges) {
            map.putIfAbsent(edge[0], new HashSet<>());
            map.get(edge[0]).add(edge[1]);
        }

        return dfs(map, visited, source, destination);
    }

    public boolean dfs(Map<Integer, Set<Integer>> map, boolean[] visited, int source,
                       int destination) {
        if (source == destination) {
            if (map.containsKey(source)) return false;
            return true;
        }
        if (!map.containsKey(source)) return false;
        for (Integer next : map.get(source)) {
            if (visited[next]) return false;

            visited[next] = true;
            if (!dfs(map, visited, next, destination)) return false;
            visited[next] = false;
        }

        return true;
    }
}
