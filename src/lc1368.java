import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/9/22
 */
public class lc1368 {

    /*
     1 which means go to the cell to the right. (i.e go from grid[i][j] to grid[i][j + 1])
     2 which means go to the cell to the left. (i.e go from grid[i][j] to grid[i][j - 1])
     3 which means go to the lower cell. (i.e go from grid[i][j] to grid[i + 1][j])
     4 which means go to the upper cell. (i.e go from grid[i][j] to grid[i - 1][j])
     */
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                dp[i][j] = -1;
            }
        }


        return bfs(grid, dp);
    }

    int[][] dir = new int[][]{{0, 0}, {0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int bfs(int[][] grid, int[][] dp) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        pq.add(new int[]{0, 0, 0});
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            if (dp[now[0]][now[1]] != -1) continue;
            if (now[0] == grid.length - 1 && now[1] == grid[0].length - 1)
                return now[2];
            dp[now[0]][now[1]] = now[2];
            System.out.println(now[0] + " " + now[1]);
            for (int i = 1; i <= 4; ++i) {
                int nextx = now[0] + dir[i][0];
                int nexty = now[1] + dir[i][1];
                if (nextx < 0 || nexty < 0 || nextx >= grid.length || nexty >= grid[0].length)
                    continue;
                if (dp[nextx][nexty] != -1) continue;
                if (i == grid[nextx][nexty]) {
                    pq.add(new int[]{nextx, nexty, now[2]});
                } else {
                    pq.add(new int[]{nextx, nexty, now[2] + 1});
                }
            }
        }
        return 0;
    }
}
