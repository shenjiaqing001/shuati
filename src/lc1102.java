import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 3/29/22
 */
public class lc1102 {
    public boolean canPass(int[][] grid, int value) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        boolean[][] vis = new boolean[n][m];
        Queue<int[]> q = new ArrayDeque<>();
        if (grid[0][0] < value) return false;
        q.add(new int[]{0, 0});
        vis[0][0] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == n - 1 && cur[1] == m - 1) return true;
            for (int[] dir : dirs) {
                int nx = cur[0] + dir[0];
                int ny = cur[1] + dir[1];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (vis[nx][ny]) continue;
                if (grid[nx][ny] < value) continue;
                vis[nx][ny] = true;
                q.add(new int[]{nx, ny});
            }
        }
        return false;
    }

    public int maximumMinimumPath(int[][] grid) {
        int left = 0;
        int right = 1_000_000_000;
        while (left < right) {
            int mid = right - (right - left) / 2;
            if (canPass(grid, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
