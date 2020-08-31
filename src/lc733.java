import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/22/20
 */
public class lc733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) return image;
        Queue<int[]> q = new LinkedList<>();
        int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        q.add(new int[]{sr, sc});
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int color = image[now[0]][now[1]];
            if (color == newColor) continue;
            image[now[0]][now[1]] = newColor;
            for (int i = 0; i < 4; ++i) {
                int nextX = now[0] + dir[i][0];
                int nextY = now[1] + dir[i][1];
                if (nextX >= 0 && nextX < image.length && nextY >= 0 &&
                        nextY < image[0].length &&
                        image[nextX][nextY] == color) {
                    q.add(new int[]{nextX, nextY});
                }
            }
        }

        return image;
    }
}
