import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/28
 */
public class lc1765 {
    public int[][] highestPeak(int[][] isWater) {
        int n = isWater.length;
        int m = isWater[0].length;
        int[][] res = new int[n][m];
        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (isWater[i][j] == 1) {
                    q.add(new int[]{i, j});
                } else {
                    res[i][j] = -1;
                }
            }
        }
        int step = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; ++s) {
                int[] now = q.poll();
                for (int[] dir : dirs) {
                    int nx = now[0] + dir[0];
                    int ny = now[1] + dir[1];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                    if (res[nx][ny] != -1) continue;
                    res[nx][ny] = step;
                    q.add(new int[]{nx, ny});
                }
            }
            step++;
        }

        return res;
    }
}
