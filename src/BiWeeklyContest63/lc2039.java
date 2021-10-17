package BiWeeklyContest63;

import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/16
 */
public class lc2039 {
    public static void main(String[] args) {
        lc2039 test = new lc2039();
        //{{9,10},{0,4},{10,11},{8,3},{0,9},{6,8},{0,1},{8,2},{11,3},{8,11},{7,6},{1,5},{4,2},{5,3},{0,7},{3,2},{11,2}}
        //{0,1,1,9,3,1,1,1,5,3,1,5}
        test.networkBecomesIdle(
                new int[][]{{9, 10}, {0, 4}, {10, 11}, {8, 3}, {0, 9}, {6, 8}, {0, 1}, {8, 2}, {11, 3}, {8, 11}, {7, 6}, {1, 5}, {4, 2}, {5, 3}, {0, 7}, {3, 2}, {11, 2}},
                new int[]{0, 1, 1, 9, 3, 1, 1, 1, 5, 3, 1, 5});
    }

    public int networkBecomesIdle(int[][] edges, int[] patience) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            map.putIfAbsent(edge[0], new HashSet<>());
            map.putIfAbsent(edge[1], new HashSet<>());
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        int n = patience.length;
        int[] dp = new int[n];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        int time = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            time++;
            for (int i = 0; i < size; ++i) {
                int now = queue.poll();
                for (Integer next : map.get(now)) {
                    if (next != 0 && dp[next] == 0) {
                        dp[next] = time;
                        queue.add(next);
                    }
                }
            }
        }
        int max = 0;

        for (int i = 1; i < n; ++i) {
            if (patience[i] >= dp[i] * 2) {
                max = Math.max(max, 2 * dp[i] + 1);
            } else {
                int need = dp[i] * 2;
                int mod = need % patience[i];
                if (mod == 0) mod = patience[i];
                int totalNeed = need * 2 - mod + 1;
                max = Math.max(max, totalNeed);
            }
        }
        return max;
    }
}
