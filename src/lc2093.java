import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2/5/22
 */
public class lc2093 {
    public int minimumCost(int n, int[][] highways, int discounts) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] highway : highways) {
            int from = highway[0];
            int to = highway[1];
            int cost = highway[2];
            map.putIfAbsent(from, new ArrayList<>());
            map.putIfAbsent(to, new ArrayList<>());
            map.get(from).add(new int[]{to, cost});
            map.get(to).add(new int[]{from, cost});
        }
        int[][] dp = new int[n][discounts + 1];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        // des, cost, used
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.add(new int[]{0, 0, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (cur[0] == n - 1) return cur[1];
            if (dp[cur[0]][cur[2]] <= cur[1]) continue;
            dp[cur[0]][cur[2]] = cur[1];
            if (!map.containsKey(cur[0])) continue;
            for (int[] next : map.get(cur[0])) {
                if (cur[2] < discounts) {
                    int cost = cur[1] + next[1] / 2;
                    if (dp[next[0]][cur[2] + 1] > cost) {
                        pq.add(new int[]{next[0], cost, cur[2] + 1});
                    }
                }
                int cost = cur[1] + next[1];
                if (dp[next[0]][cur[2]] > cost) {
                    pq.add(new int[]{next[0], cost, cur[2]});
                }
            }
        }

        return -1;
    }
}
