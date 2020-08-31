import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/23/20
 */
public class lc490 {

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int height = maze.length + 2;
        int length = maze[0].length + 2;
        int[][] m = new int[height][length];
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < length; ++j) {
                if (i == 0 || j == 0 || i == height - 1 || j == length - 1)
                    m[i][j] = 1;
                else
                    m[i][j] = maze[i - 1][j - 1];
            }
        }
        start[0]++;
        start[1]++;
        destination[0]++;
        destination[1]++;

        int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        m[start[0]][start[1]] = 2;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            if (now[0] == destination[0] && now[1] == destination[1])
                return true;

            for (int i = 0; i < 4; ++i) {
                int count = 1;
                while (m[now[0] + count * dir[i][0]][now[1] +
                        count * dir[i][1]] != 1) {
                    count++;
                }
                count--;
                if (m[now[0] + count * dir[i][0]][now[1] +
                        count * dir[i][1]] == 2) continue;
                int[] next = new int[]{now[0] + count * dir[i][0],
                        now[1] + count * dir[i][1]};
                m[next[0]][next[1]] = 2;
                q.offer(next);
            }
        }
        return false;
    }

}
