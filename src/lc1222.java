import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 1/20/22
 */
public class lc1222 {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        int[][] dirs =
                new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
        List<List<Integer>> res = new ArrayList<>();
        int[][] board = new int[8][8];
        for (int[] q : queens) {
            board[q[0]][q[1]] = 1;
        }

        for (int[] dir : dirs) {
            int steps = 1;
            while (true) {
                int x = king[0] + steps * dir[0];
                int y = king[1] + steps * dir[1];
                if (x < 0 || y < 0 || x >= 8 || y >= 8) break;
                if (board[x][y] == 1) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(x);
                    tmp.add(y);
                    res.add(tmp);
                    break;

                }
                steps++;
            }
        }

        return res;
    }
}
