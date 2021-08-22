package WeeklyContest254;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/8/14
 */
public class lc1970 {
    int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int latestDayToCross(int row, int col, int[][] cells) {
        int left = 0;
        int right = cells.length - 1;

        while (left < right) {
            int mid = right - (right - left) / 2;
            if (bfs(cells, row, col, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public boolean bfs(int[][] cells, int row, int col, int day) {
        int[][] grid = new int[row][col];
        for (int i = 0; i < day; ++i) {
            grid[cells[i][0] - 1][cells[i][1] - 1] = 1;
        }
        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < col; ++i) {
            if (grid[0][i] == 0) {
                grid[0][i] = 1;
                q.add(new int[]{0, i});
            }
        }
        while (!q.isEmpty()) {
            int[] now = q.poll();
            if (now[0] == row - 1) return true;
            for (int i = 0; i < 4; ++i) {
                int nextx = now[0] + dir[i][0];
                int nexty = now[1] + dir[i][1];
                if (nextx < 0 || nexty < 0 || nextx >= row || nexty >= col)
                    continue;
                if (grid[nextx][nexty] == 1)
                    continue;
                grid[nextx][nexty] = 1;
                q.add(new int[]{nextx, nexty});
            }
        }
        return false;
    }


}
