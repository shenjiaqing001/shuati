package LeetCodeContest.Fall2021.个人赛;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/9/11
 */
public class lc3 {
    int n, m;
    int[][] dirs =
            new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    public static void main(String[] args) {
        lc3 test = new lc3();
        System.out.println(
                test.flipChess(new String[]{"....X.", "....X.", "XOOO..", "......", "......"}));
    }

    public int flipChess(String[] chessboard) {
        n = chessboard.length;
        m = chessboard[0].length();
        char[][] c = new char[chessboard.length][];
        for (int i = 0; i < n; ++i) {
            c[i] = chessboard[i].toCharArray();
        }
        int max = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (c[i][j] == '.')
                    max = Math.max(max, check(c, i, j));
            }
        }
        return max;
    }

    public int check(char[][] c, int x, int y) {
        char[][] myBoard = new char[n][m];
        for (int i = 0; i < n; ++i) {
            if (m >= 0) System.arraycopy(c[i], 0, myBoard[i], 0, m);
        }
        int res = 0;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x, y});
        myBoard[x][y] = 'X';
        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int[] dir : dirs) {
                int nextx = now[0] + dir[0];
                int nexty = now[1] + dir[1];
                if (nexty < 0 || nextx < 0 || nextx >= n || nexty >= m) continue;
                if (myBoard[nextx][nexty] != 'O') continue;
                int step = 2;
                while (true) {
                    int boundx = now[0] + dir[0] * step;
                    int boundy = now[1] + dir[1] * step;
                    if (boundx < 0 || boundy < 0 || boundx >= n || boundy >= m) break;
                    if (myBoard[boundx][boundy] == '.') break;
                    if (myBoard[boundx][boundy] == 'O') {
                        step++;
                    } else {
                        for (int i = 1; i < step; ++i) {
                            q.add(new int[]{now[0] + dir[0] * i, now[1] + dir[1] * i});
                            res++;
                            myBoard[now[0] + dir[0] * i][now[1] + dir[1] * i] = 'X';
                        }
                        break;
                    }
                }
            }
        }
        return res;
    }
}
