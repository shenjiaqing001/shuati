import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/16
 */
public class lc542 {
    public int[][] updateMatrix(int[][] matrix) {
        int x = matrix.length;
        int y = matrix[0].length;
        boolean[][] visited = new boolean[x][y];

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < x; ++i) {
            for (int j = 0; j < y; ++j) {
                if (matrix[i][j] == 0) {
                    q.add(new int[]{i, j});
                }
            }
        }
        int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int i = 0; i < 4; ++i) {
                int nextx = now[0] + dir[i][0];
                int nexty = now[1] + dir[i][1];
                if (nextx < 0 || nexty < 0 || nextx >= matrix.length || nexty >= matrix[0].length)
                    continue;
                if (matrix[nextx][nexty] == 0 || visited[nextx][nexty] == true)
                    continue;

                visited[nextx][nexty] = true;
                matrix[nextx][nexty] = matrix[now[0]][now[1]] + 1;
                q.add(new int[]{nextx, nexty});
            }
        }

        return matrix;
    }

}
