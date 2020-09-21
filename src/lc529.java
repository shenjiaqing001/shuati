import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/9/22
 */
public class lc529 {
    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0];
        int y = click[1];
        if (board[x][y] == 'X' || board[x][y] == 'B' || (board[x][y] >= '0' && board[x][y] <= '8'))
            return board;
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        }
        bfs(board, x, y);
        return board;
    }


    public void bfs(char[][] grid, int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        while (!q.isEmpty()) {
            int[] now = q.poll();
            if (grid[now[0]][now[1]] != 'E') continue;
            int num = count(grid, now[0], now[1]);
            if (num >= 1) grid[now[0]][now[1]] = (char) (num + '0');
            else {
                grid[now[0]][now[1]] = 'B';

                for (int i = -1; i <= 1; ++i) {
                    for (int j = -1; j <= 1; ++j) {
                        if (now[0] + i < 0 || now[0] + i >= grid.length || now[1] + j < 0 ||
                                now[1] + j >= grid[0].length)
                            continue;
                        if (grid[now[0] + i][now[1] + j] == 'E') {
                            q.add(new int[]{now[0] + i, now[1] + j});
                        }
                    }
                }
            }
        }
    }

    public int count(char[][] board, int x, int y) {
        int res = 0;
        for (int i = -1; i <= 1; ++i) {
            for (int j = -1; j <= 1; ++j) {
                if (i + x < 0 || i + x >= board.length || j + y < 0 || j + y >= board[0].length)
                    continue;

                if (board[x + i][y + j] == 'M' || board[x + i][y + j] == 'X')
                    res++;
            }
        }
        return res;
    }

}
