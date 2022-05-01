import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 3/23/22
 */
public class lc1786 {
    public int countRestrictedPaths(int n, int[][] edges) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.putIfAbsent(edge[0], new HashMap<>());
            graph.putIfAbsent(edge[1], new HashMap<>());
            graph.get(edge[0]).put(edge[1], edge[2]);
            graph.get(edge[1]).put(edge[0], edge[2]);
        }
        boolean[] vis = new boolean[n + 1];
        int[] dis = new int[n + 1];
        // [node, distance]
        PriorityQueue<int[]> pq = new PriorityQueue<>(((o1, o2) -> (o1[1] - o2[1])));
        pq.add(new int[]{n, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (vis[cur[0]]) continue;
            vis[cur[0]] = true;
            dis[cur[0]] = cur[1];
            if (!graph.containsKey(cur[0])) continue;
            Map<Integer, Integer> neighbors = graph.get(cur[0]);
            for (int key : neighbors.keySet()) {
                if (vis[key]) continue;
                pq.add(new int[]{key, cur[1] + neighbors.get(key)});
            }
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        // cur
        TreeSet<Integer> treeSet =
                new TreeSet<>(((o1, o2) -> (dis[o1] == dis[o2] ? o1 - o2 : -dis[o1] + dis[o2])));
        treeSet.add(1);
        while (!treeSet.isEmpty()) {
            int cur = treeSet.pollFirst();
            if (!graph.containsKey(cur)) continue;
            Map<Integer, Integer> neighbors = graph.get(cur);
            for (int key : neighbors.keySet()) {
                if (dis[key] < dis[cur]) {
                    dp[key] += dp[cur];
                    dp[key] %= 1_000_000_007;
                    treeSet.add(key);
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        lc1786 test = new lc1786();
        test.countRestrictedPaths(5,
                new int[][]{{1, 2, 3}, {1, 3, 3}, {2, 3, 1}, {1, 4, 2}, {5, 2, 2}, {3, 5, 1}, {5, 4, 10}});
    }


}
