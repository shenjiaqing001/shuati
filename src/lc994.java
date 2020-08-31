import java.util.LinkedList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/10/20
 */
public class lc994 {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        List<int[]> q = new LinkedList<>();

        int remain = 0;
        int res = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 2)
                    q.add(new int[]{i, j});
                if (grid[i][j] == 1)
                    remain++;
            }
        }
        if(remain == 0) return 0;

        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!q.isEmpty()) {
            System.out.println(q.size());
            res++;
            int now_size = q.size();
            for (int i = 0; i < now_size; ++i) {
                int[] now = q.remove(0);
                for (int j = 0; j < 4; ++j) {
                    int x = now[0] + dir[j][0];
                    int y = now[1] + dir[j][1];
                    if (x < 0 || y < 0 || x >= grid.length ||
                            y >= grid[0].length || grid[x][y] == 0 ||
                            grid[x][y] == 2) continue;
                    grid[x][y] = 2;
                    q.add(new int[]{x, y});
                    remain--;
                }
            }
        }
        System.out.println(remain);
        if (remain != 0) return -1;
        return res - 1;
    }

    public static void main(String[] args) {
        lc994 t = new lc994();
        System.out.println(
                t.orangesRotting(new int[][]{{0}}));
    }
}
