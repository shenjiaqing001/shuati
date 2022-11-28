package LeetCodeContest.Fall2022;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/24/22
 */
public class lc3 {
    int[][] dirs = new int[][]{{}, {0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public List<int[]> nextNode(char[][] p, int[] n) {
        List<int[]> res = new ArrayList<>();
        if (n[2] == 0) {
            for (int d = 1; d <= 4; ++d) {
                int nx = n[0] + dirs[d][0];
                int ny = n[1] + dirs[d][1];
                if (nx < 0 || ny < 0 || nx >= p.length || ny >= p[0].length) continue;
                if (p[nx][ny] == 'O') continue;
                if (p[nx][ny] == '.') res.add(new int[]{nx, ny, d});
                if (p[nx][ny] == 'E') {
                    int nd = d - 1;
                    if (nd == 0) nd = 4;
                    res.add(new int[]{nx, ny, nd});
                }
                if (p[nx][ny] == 'W') {
                    int nd = d + 1;
                    if (nd == 5) nd = 1;
                    res.add(new int[]{nx, ny, nd});
                }
            }
        } else {
            int d = n[2];
            int nx = n[0] + dirs[d][0];
            int ny = n[1] + dirs[d][1];
            if (!(nx < 0 || ny < 0 || nx >= p.length || ny >= p[0].length)) {
                if (p[nx][ny] != 'O') {
                    if (p[nx][ny] == '.') res.add(new int[]{nx, ny, d});
                    if (p[nx][ny] == 'E') {
                        int nd = d - 1;
                        if (nd == 0) nd = 4;
                        res.add(new int[]{nx, ny, nd});
                    }
                    if (p[nx][ny] == 'W') {
                        int nd = d + 1;
                        if (nd == 5) nd = 1;
                        res.add(new int[]{nx, ny, nd});
                    }
                }
            }
        }
        return res;
    }


    public int[][] ballGame(int num, String[] plate) {
        int n = plate.length;
        int m = plate[0].length();
        char[][] p = new char[n][];
        for (int i = 0; i < n; ++i) {
            p[i] = plate[i].toCharArray();
        }
        int[][][] count = new int[n][m][5];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                for (int d = 1; d <= 4; ++d)
                    count[i][j][d] = Integer.MAX_VALUE;
            }
        }
        Queue<int[]> q = new ArrayDeque<>();
        // x,y,direction.  0 any,
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (p[i][j] == 'O') {
                    q.add(new int[]{i, j, 0});
                }
            }
        }
        // 0 any, 1E 2S 3W 4N
        int steps = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; ++s) {
                int[] node = q.poll();
                List<int[]> next = nextNode(p, node);
                for (int[] nx : next) {
                    if (count[nx[0]][nx[1]][nx[2]] > steps) {
                        count[nx[0]][nx[1]][nx[2]] = steps;
                        q.add(nx);
                    }
                }
            }
            if (steps == num) break;
            steps++;
        }
        List<int[]> res = new ArrayList<>();
        for (int i = 1; i < n - 1; ++i) {
            if (p[i][0] == '.' && count[i][0][3] <= num) res.add(new int[]{i, 0});
            if (p[i][m - 1] == '.' && count[i][m - 1][1] <= num) res.add(new int[]{i, m - 1});
        }
        for (int i = 1; i < m - 1; ++i) {
            if (p[0][i] == '.' && count[0][i][4] <= num) res.add(new int[]{0, i});
            if (p[n - 1][i] == '.' && count[n - 1][i][2] <= num) res.add(new int[]{n - 1, i});
        }
        int[][] tmp = new int[res.size()][];
        for (int i = 0; i < res.size(); ++i) {
            tmp[i] = res.get(i);
        }
        return tmp;
    }

    public static void main(String[] args) {
        lc3 test = new lc3();
        test.ballGame(50, new String[]{".E.W....E","WW..EE..E","...WE.W.E","..WWE....",".WW...WEW","..W...WEE",".EE..W..E","OE..W.W.."});
    }
}
