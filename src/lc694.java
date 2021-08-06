import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/26/20
 */
public class lc694 {
    public int numDistinctIslands(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int x = grid.length;
        int y = grid[0].length;
        Set<String> set = new HashSet<>();

        for (int i = 0; i < x; ++i) {
            for (int j = 0; j < y; ++j) {
                if (grid[i][j] == 1) {
                    StringBuffer sb = new StringBuffer();
                    dfs(grid, i, j, sb, "o");
                    set.add(sb.toString());
                }
            }
        }
        return set.size();
    }

    public void dfs(int[][] grid, int x, int y, StringBuffer sb, String dir) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length)
            return;
        if (grid[x][y] == 0)
            return;
        sb.append(dir);
        grid[x][y] = 0;
        dfs(grid, x + 1, y, sb, "u");
        dfs(grid, x - 1, y, sb, "d");
        dfs(grid, x, y + 1, sb, "r");
        dfs(grid, x, y - 1, sb, "l");
        sb.append("b");
    }

    public int numDistinctIslands2(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int x = grid.length;
        int y = grid[0].length;
        Set<String> set = new HashSet<>();

        for (int i = 0; i < x; ++i) {
            for (int j = 0; j < y; ++j) {
                if (grid[i][j] == 1) {
                    set.add(bfs(grid, i, j));
                }
            }
        }
        return set.size();
    }

    int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public String bfs(int[][] grid, int x, int y) {
        List<int[]> list = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        grid[x][y] = 0;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            list.add(new int[]{now[0] - x, now[1] - y});
            for (int i = 0; i < 4; ++i) {
                int nx = now[0] + dir[i][0];
                int ny = now[1] + dir[i][1];
                if (nx < 0 || ny < 0 || nx >= grid.length || ny >= grid[0].length)
                    continue;
                if (grid[nx][ny] == 0)
                    continue;
                grid[nx][ny] = 0;
                queue.add(new int[]{nx, ny});
            }
        }
        list.sort((o1, o2) -> (o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]));

        StringBuilder sb = new StringBuilder();
        for (int[] xy : list) {
            sb.append(xy[0] + "," + xy[1] + ";");
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
}
