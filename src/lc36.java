/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/8/21
 */
public class lc36 {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] != '.' && !check(board, i, j)) return false;
            }
        }
        return true;
    }

    public boolean check(char[][] board, int x, int y) {
        for (int i = 0; i < 9; ++i) {
            if (i != x && board[i][y] == board[x][y]) return false;
            if (i != y && board[x][i] == board[x][y]) return false;
        }

        for (int i = 3 * (x / 3); i < 3 + 3 * (x / 3); ++i) {
            for (int j = 3 * (y / 3); j < 3 + 3 * (y / 3); ++j) {
                if ((i != x || j != y) && board[i][j] == board[x][y]) return false;
            }
        }
        return true;
    }

}
