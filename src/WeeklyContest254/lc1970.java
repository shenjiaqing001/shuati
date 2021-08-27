package WeeklyContest254;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/8/14
 */
public class lc1970 {
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

    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int[] p;

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
                int nextx = now[0] + dirs[i][0];
                int nexty = now[1] + dirs[i][1];
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

    int get(int x) {
        return p[x] == x ? x : (p[x] = get(p[x]));
    }

    void union(int x, int y) {
        int a = get(x);
        int b = get(y);
        if (p[a] < p[b]) p[b] = p[a];
        else p[a] = p[b];
    }

    public int latestDayToCross2(int row, int col, int[][] cells) {
        p = new int[row * col];
        for (int i = 0; i < row * col; ++i) p[i] = i;

        int[][] map = new int[row][col];
        for (int i = cells.length - 1; i >= 0; --i) {
            int[] cell = cells[i];
            cell[0] -= 1;
            cell[1] -= 1;
            map[cell[0]][cell[1]] = 1;

            for (int[] dir : dirs) {
                int nextx = cell[0] + dir[0];
                int nexty = cell[1] + dir[1];
                if (nextx < 0 || nexty < 0 || nextx >= row || nexty >= col) continue;
                if (map[nextx][nexty] == 0) continue;
                union(cell[0] * col + cell[1], nextx * col + nexty);
            }

            for (int j = 0; j < col; ++j) {
                if (get((row - 1) * col + j) / col == 0) return i;
            }

            for (int ii = 0; ii < row; ++ii) {
                for (int jj = 0; jj < col; ++jj) {
                    System.out.print(get(ii * col + jj) + " ");
                }
                System.out.println();
            }

        }
        return 0;
    }


}
