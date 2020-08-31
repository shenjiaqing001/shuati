package WeeklyContest204;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/30/20
 */
public class lc3 {
    public int minDays(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int x = grid.length;
        int y = grid[0].length;
        boolean[][] visited = new boolean[x][y];
        int res = Integer.MAX_VALUE;
        int minsize = Integer.MAX_VALUE;


        visit = new boolean[x][y];
        dfn = new int[x][y];
        val = new int[x][y];


        int flag = 0;
        boolean flag2 = false;
        int count = 0;
        for (int i = 0; i < x; ++i) {
            for (int j = 0; j < y; ++j) {
                if (grid[i][j] == 1 && visited[i][j] == false) {
                    minsize = Math.min(minsize, bfs(grid, i, j, visited));
                    count++;
                }
                if (grid[i][j] == 1) {
                    int con = detect(grid, i, j);
                    res = Math.min(res, con);
                    if (con == 5) flag++;
                }
                if (!visit[i][j]) {
                    if (dfs(grid, i, j, i, j)) {
                        flag2 = true;
                    }
                }
            }
        }

        System.out.println(flag);
        if (count >= 2 || count == 0) return 0;
        else {
            if (minsize == 1) return 1;
            else if (minsize == 2) return 2;
            else if (flag == 1) return 1;
            else if (flag2 == true) return 1;
            else return res;
        }
    }

    int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int bfs(int[][] grid, int x, int y, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;
        int count = 0;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            count++;
            for (int i = 0; i < 4; ++i) {
                int nextx = now[0] + dir[i][0];
                int nexty = now[1] + dir[i][1];
                if (nextx < 0 || nexty < 0 || nextx >= grid.length || nexty >= grid[0].length)
                    continue;
                if (grid[nextx][nexty] == 0 || visited[nextx][nexty] == true)
                    continue;

                visited[nextx][nexty] = true;
                q.add(new int[]{nextx, nexty});
            }
        }
        return count;
    }

    public int detect(int[][] grid, int x, int y) {
        int res = 0;


        try {
            if ((grid[x - 1][y] == 1 && grid[x + 1][y] == 1 && (y - 1 < 0 || grid[x][y - 1] == 0) &&
                    (y + 1 >= grid[0].length || grid[x][y + 1] == 0)) ||
                    ((x - 1 < 0 || grid[x - 1][y] == 0) &&
                            (x + 1 >= grid.length || grid[x + 1][y] == 0) &&
                            grid[x][y - 1] == 1 && grid[x][y + 1] == 1))
                return 5;
        } catch (Exception e) {

        }


        if (x - 1 >= 0 && grid[x - 1][y] == 1)
            res++;
        if (x + 1 < grid.length && grid[x + 1][y] == 1)
            res++;
        if (y - 1 >= 0 && grid[x][y - 1] == 1)
            res++;
        if (y + 1 < grid[0].length && grid[x][y + 1] == 1)
            res++;
        return res;
    }


    boolean[][] visit;
    int[][] dfn;
    int[][] val;
    int time = 1;

    public boolean dfs(int[][] grid, int x, int y, int parentx, int parenty) {
        dfn[x][y] = time;
        val[x][y] = time;
        time++;
        visit[x][y] = true;

        for (int i = 0; i < 4; ++i) {
            int nextx = x + dir[i][0];
            int nexty = y + dir[i][1];
            if (nextx < 0 || nexty < 0 || nextx >= grid.length || nexty >= grid[0].length)
                continue;
            if (nextx == parentx && nexty == parenty)
                continue;


            if (grid[nextx][nexty] == 0 || visit[nextx][nexty] == true)
                continue;

            if (!visit[nextx][nexty]) {
                boolean flag = dfs(grid, nextx, nexty, x, y);
                if (flag == true) return true;

                val[x][y] = Math.min(val[x][y], val[nextx][nexty]);
                if (dfn[x][y] < val[nextx][nexty]) {
                    return true;
                }
            } else {
                val[x][y] = Math.min(dfn[nextx][nexty], val[x][y]);
            }
        }
        return false;
    }
}
