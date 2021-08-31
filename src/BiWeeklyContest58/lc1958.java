package BiWeeklyContest58;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/8/7
 */
public class lc1958 {
    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        int[][] dir =
                new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

        for (int i = 0; i < 8; ++i) {
            boolean flag = false;
            int count = 0;
            int step = 1;
            while (true) {
                int nx = rMove + dir[i][0] * step;
                int ny = cMove + dir[i][1] * step;
                if (nx < 0 || ny < 0 || nx >= board.length || ny >= board[0].length) break;
                if (board[nx][ny] == '.') break;
                if (board[nx][ny] == color) {
                    if (!flag) break;
                    count++;
                } else {
                    flag = true;
                }
                if (count == 1) return true;
                step++;
            }
            if (flag && count == 1) return true;
        }
        return false;
    }
}
