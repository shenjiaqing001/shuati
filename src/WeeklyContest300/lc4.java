package WeeklyContest300;

import java.util.PriorityQueue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/2/22
 */
public class lc4 {
    public int countPaths(int[][] grid) {
        long res = 0;
        int n = grid.length;
        int m = grid[0].length;
        long[][] dp = new long[n][m];
        long mod = 1_000_000_007;
        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o1[2] - o2[2]));
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                dp[i][j] = 1;
                pq.add(new int[]{i, j, grid[i][j]});
            }
        }
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            res += dp[now[0]][now[1]];
            res %= mod;
            for (int[] dir : dirs) {
                int nx = now[0] + dir[0];
                int ny = now[1] + dir[1];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (grid[now[0]][now[1]] >= grid[nx][ny]) continue;
                dp[nx][ny] += dp[now[0]][now[1]];
                dp[nx][ny] %= mod;
            }
        }
        return (int) res;
    }
}
