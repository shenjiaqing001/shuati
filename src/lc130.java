/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/5/20
 */
public class lc130 {

    public void solve(char[][] board) {
        if (board.length == 0) return;
        if (board[0].length == 0) return;

        int x = board.length - 1;
        int y = board[0].length - 1;

        for (int i = 0; i <= x; ++i) {
            if (board[i][0] == 'O')
                dfs(board, i, 0);
            if (board[i][y] == 'O')
                dfs(board, i, y);
        }

        for (int i = 1; i <= y - 1; ++i) {
            if (board[0][i] == 'O')
                dfs(board, 0, i);
            if (board[x][i] == 'O')
                dfs(board, x, i);
        }

        for (int i = 0; i <= x; ++i) {
            for (int j = 0; j <= y; ++j) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                if (board[i][j] == '*')
                    board[i][j] = 'O';
            }
        }
    }

    public void dfs(char[][] board, int x, int y) {
        if (board[x][y] == 'O')
            board[x][y] = '*';

        if (x - 1 > 0 && board[x - 1][y] == 'O')
            dfs(board, x - 1, y);
        if (x + 1 < board.length && board[x + 1][y] == 'O')
            dfs(board, x + 1, y);
        if (y - 1 > 0 && board[x][y - 1] == 'O')
            dfs(board, x, y - 1);
        if (y + 1 < board[0].length && board[x][y + 1] == 'O')
            dfs(board, x, y + 1);
    }
}
