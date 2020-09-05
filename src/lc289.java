/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/4/20
 */
public class lc289 {

    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                int res = cal(board, i, j);
                if (board[i][j] == 1) {
                    if (res == 2 || res == 3)
                        continue;
                    else
                        board[i][j] = 2;
                } else {
                    if (res == 3)
                        board[i][j] = 3;
                }
            }
        }
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (board[i][j] == 2) board[i][j] = 0;
                if (board[i][j] == 3) board[i][j] = 1;
            }
        }
    }

    public int cal(int[][] board, int x, int y) {
        int res = 0;
        for (int i = -1; i <= 1; ++i) {
            for (int j = -1; j <= 1; ++j) {
                if (x + i < 0 || x + i >= board.length || y + j < 0 || y + j >= board[0].length)
                    continue;
                if (board[x + i][y + j] == 1) res++;
                if (board[x + i][y + j] == 2) res++;
            }
        }
        res -= board[x][y];
        return res;
    }


}
