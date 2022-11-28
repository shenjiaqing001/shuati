package WeeklyContest295;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 5/28/22
 */
public class lc4 {
    Queue<int[]> q = new ArrayDeque<>();
    boolean[][] flag;
    int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public void add(int i, int j, int[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return;
        if (grid[i][j] == 0 && !flag[i][j]) {
            flag[i][j] = true;
            q.add(new int[]{i, j});
            for (int[] dir : dirs) {
                add(i + dir[0], j + dir[1], grid);
            }
        }
    }

    public int minimumObstacles(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        flag = new boolean[n][m];
        add(0, 0, grid);
        int steps = 0;
        while (true) {
            if (flag[n - 1][m - 1]) return steps;
            steps++;
            int size = q.size();
            for (int s = 0; s < size; ++s) {
                int[] p = q.poll();
                for (int[] dir : dirs) {
                    int nx = p[0] + dir[0];
                    int ny = p[1] + dir[1];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                    if (grid[nx][ny] == 1) {
                        grid[nx][ny] = 0;
                        add(nx, ny, grid);
                    }
                }
            }
        }
    }
}
