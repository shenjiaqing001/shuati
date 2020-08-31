import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/25/20
 */
public class lc909 {

    int n;

    public int snakesAndLadders(int[][] board) {
        n = board.length;
        boolean[] visited = new boolean[n * n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        int step = 1;
        visited[1] = true;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int t = 0; t < size; ++t) {
                int now = q.poll();
                for (int i = 1; i <= 6; ++i) {
                    int next = now + i;
                    int[] tmp = numToPos(next);
                    if (board[tmp[0]][tmp[1]] != -1) {
                        next = board[tmp[0]][tmp[1]];
                    }
                    if (next == n * n) return step;
                    if (next > n * n) continue;
                    if (visited[next]) continue;
                    visited[next] = true;
                    q.add(next);
                }
            }
            step++;
        }
        return -1;
    }

    private int[] numToPos(int target) {
        int row = (target - 1) / n, col = (target - 1) % n;
        int x = n - 1 - row, y = row % 2 == 0 ? col : n - 1 - col;
        return new int[]{x, y};
    }

    private int posToNum(int[] position) {
        int row = (n - 1 - position[0]);
        int y = row % 2 == 0 ? position[1] + 1 : n - position[1];
        return row * n + y;
    }
}
