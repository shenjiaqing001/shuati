import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/11/17
 */
public class lc505 {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int[][] map = new int[maze.length][maze[0].length];
        for (int i = 0; i < map.length; ++i) {
            for (int j = 0; j < map[0].length; ++j) {
                map[i][j] = -1;
            }
        }

        map[start[0]][start[1]] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int i = 0; i < 4; ++i) {
                int x = now[0] + dir[i][0];
                int y = now[1] + dir[i][1];
                int count = 0;
                while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length &&
                        maze[x][y] == 0) {
                    x += dir[i][0];
                    y += dir[i][1];
                    count++;
                }
                if (map[x - dir[i][0]][y - dir[i][1]] == -1 ||
                        map[now[0]][now[1]] + count < map[x - dir[i][0]][y - dir[i][1]]) {
                    map[x - dir[i][0]][y - dir[i][1]] = map[now[0]][now[1]] + count;
                    q.add(new int[]{x - dir[i][0], y - dir[i][1]});
                }
            }
        }

        return map[destination[0]][destination[1]];
    }
}
