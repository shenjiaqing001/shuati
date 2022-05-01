import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 1/27/22
 */
public class lc802 {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] inDegree = new int[n];
        boolean[] visited = new boolean[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < graph.length; ++i) {
            for (int neighbor : graph[i]) {
                map.putIfAbsent(neighbor, new ArrayList<>());
                map.get(neighbor).add(i);
                inDegree[i]++;
            }
        }
        List<Integer> res = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            if (inDegree[i] == 0) {
                q.add(i);
                res.add(i);
                visited[i] = true;
            }
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (!map.containsKey(cur)) continue;
            for (int next : map.get(cur)) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    q.add(next);
                    res.add(next);
                    visited[next] = true;
                }
            }
        }
        res.sort(Comparator.comparingInt(o -> o));
        return res;
    }
}
