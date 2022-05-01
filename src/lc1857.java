import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 1/26/22
 */
public class lc1857 {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        char[] c = colors.toCharArray();
        int[] inDegree = new int[n];
        int[][] dp = new int[n][26];
        boolean[] visited = new boolean[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            map.putIfAbsent(edge[0], new ArrayList<>());
            map.get(edge[0]).add(edge[1]);
            inDegree[edge[1]]++;
        }
        int max = 0;
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            if (inDegree[i] == 0) {
                q.add(i);
                dp[i][c[i] - 'a']++;
                visited[i] = true;
            }
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (!map.containsKey(cur)) continue;
            for (int next : map.get(cur)) {
                inDegree[next]--;
                for (int i = 0; i < 26; ++i) {
                    dp[next][i] = Math.max(dp[next][i], dp[cur][i]);
                }
                if (inDegree[next] == 0) {
                    q.add(next);
                    visited[next] = true;
                    dp[next][c[next] - 'a']++;
                }
            }
        }
        for (int i = 0; i < n; ++i) {
            if (!visited[i]) return -1;
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < 26; ++j) {
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}
