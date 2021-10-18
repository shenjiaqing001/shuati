import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/17
 */
public class lc302 {
    public int minArea(char[][] image, int x, int y) {
        int l = y, r = y, t = x, d = x;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y});
        boolean[][] visited = new boolean[image.length][image[0].length];
        visited[x][y] = true;
        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int[] dir : dirs) {
                int nx = now[0] + dir[0];
                int ny = now[1] + dir[1];
                if (nx < 0 || ny < 0 || nx >= image.length || ny >= image[0].length) continue;
                if (image[nx][ny] == '0' || visited[nx][ny]) continue;
                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny});
                l = Math.min(l, ny);
                r = Math.max(r, ny);
                t = Math.min(t, nx);
                d = Math.max(d, nx);
            }
        }
        return (r - l + 1) * (t - d + 1);
    }
}
