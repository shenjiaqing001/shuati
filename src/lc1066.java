/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/5/20
 */
public class lc1066 {
    int min = Integer.MAX_VALUE;

    public int assignBikes(int[][] workers, int[][] bikes) {
        boolean[] visited = new boolean[bikes.length];
        int n = workers.length;
        int m = bikes.length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                dp[i][j] = dis(workers[i], bikes[j]);
            }
        }

        dfs(dp, visited, 0, 0);
        return min;
    }

    public void dfs(int[][] dp, boolean[] visited, int now, int dis) {
        if (now == dp.length) {
            min = Math.min(min, dis);
            return;
        }

        for (int i = 0; i < dp[0].length; ++i) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(dp, visited, now + 1, dis + dp[now][i]);
                visited[i] = false;
            }
        }
    }

    public int dis(int[] worker, int[] bike) {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }
}
