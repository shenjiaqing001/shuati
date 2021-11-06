package BiWeeklyContest64;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/30
 */
public class lc2056 {

    int[][] dRook = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    int[][] dBishop = new int[][]{{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    int[][] dQueen =
            new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    List<int[][]> list = new ArrayList<>();
    int[][][] d;
    int res = 0;

    public int countCombinations(String[] pieces, int[][] positions) {
        // rook queen bishop
        int n = pieces.length;
        int[][] dp = new int[n][n];
        int[] count = new int[n];

        d = new int[pieces.length][][];
        for (int p = 0; p < pieces.length; ++p) {
            if (pieces[p].equals("rook")) {
                d[p] = dRook;
            }
            if (pieces[p].equals("bishop")) {
                d[p] = dBishop;
            }
            if (pieces[p].equals("queen")) {
                d[p] = dQueen;
            }
        }

        int[] com = new int[pieces.length];
        dfs(com, 0);

        for (int[][] c : list) {
            int state = (1 << n) - 1;


        }


        return res;
    }

    public void dfs2(int[][] c, int state, int[][] p) {
        if (state == 0) {
            res++;
            return;
        }

        for (int i = 0; i < c.length; ++i) {
            if ((state & (1 << i)) > 0) {
                state = state & (1 << i);
                dfs2(c, state, p);
                state |= (1 << i);
            }
        }


    }


    public void dfs(int[] com, int level) {
        if (level == com.length) {
            int[][] one = new int[com.length][2];
            for (int i = 0; i < level; ++i) {
                one[i] = d[i][com[i]];
            }
            list.add(one);
            return;
        }
        for (int i = 0; i < d[level].length; ++i) {
            com[level] = i;
            dfs(com, level + 1);
        }
    }


}
