import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/6/27
 */
public class lc417 {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[][] dp = new int[n][m];


        Queue<int[]> pacQ = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; ++i) {
            pacQ.add(new int[]{i, 0});
            dp[i][0] += 1;
            visited[i][0] = true;
        }
        for (int j = 1; j < m; ++j) {
            pacQ.add(new int[]{0, j});
            dp[0][j] += 1;
            visited[0][j] = true;
        }
        bfs(heights, visited, dp, pacQ, 1);


        Queue<int[]> atlQ = new LinkedList<>();
        visited = new boolean[n][m];
        for (int i = 0; i < n; ++i) {
            atlQ.add(new int[]{i, m - 1});
            dp[i][m - 1] += 2;
            visited[i][m - 1] = true;
        }
        for (int j = 0; j < m - 1; ++j) {
            atlQ.add(new int[]{n - 1, j});
            dp[n - 1][j] += 2;
            visited[n - 1][j] = true;
        }
        bfs(heights, visited, dp, atlQ, 2);

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                System.out.print(dp[i][j]);
            }
            System.out.println();
        }

        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (dp[i][j] == 3) {
                    List<Integer> tmp = new LinkedList<>();
                    tmp.add(i);
                    tmp.add(j);
                    res.add(tmp);
                }
            }
        }
        return res;
    }

    int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public void bfs(int[][] grid, boolean[][] visited, int[][] dp, Queue<int[]> q, int lvl) {
        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int i = 0; i < 4; ++i) {
                int nextx = now[0] + dir[i][0];
                int nexty = now[1] + dir[i][1];
                if (nextx < 0 || nexty < 0 || nextx >= grid.length || nexty >= grid[0].length)
                    continue;
                if (visited[nextx][nexty] || grid[nextx][nexty] < grid[now[0]][now[1]])
                    continue;

                visited[nextx][nexty] = true;
                dp[nextx][nexty] += lvl;
                q.add(new int[]{nextx, nexty});
            }
        }
    }
}
