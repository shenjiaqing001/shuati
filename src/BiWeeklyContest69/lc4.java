package BiWeeklyContest69;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 1/8/22
 */
public class lc4 {

    int[][] flag;

    public void helper(int[][] grid, int stampHeight, int stampWidth,
                       int s1, int s2, int step1, int step2) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] topdown = new int[n + 2][m + 2];
        int[][] tmp = new int[n][m];
        int i = s1;
        while (i >= 0 && i < n) {
            int j = s2;
            while (j >= 0 && j < m) {
                if (grid[i][j] != 1) topdown[i + 1][j + 1] = topdown[i + 1 - step1][j + 1] + 1;
                j += step2;
            }
            i += step1;
        }

        i = s1 + 1;
        while (i >= 1 && i <= n) {
            int j = s2 + 1;
            int last = -1;
            while (j >= 1 && j <= m) {
                if (topdown[i][j] < stampHeight) last = -1;
                else {
                    // System.out.println(i + " " + j + " " + topdown[i][j]) ;
                    if (last == -1) {
                        last = j;
                        if (step2 * (j - last) >= stampWidth - 1) tmp[i - 1][j - 1] = 1;
                    } else if (step2 * (j - last) >= stampWidth - 1) tmp[i - 1][j - 1] = 1;
                }
                j += step2;
            }
            i += step1;
        }

        int[][] res = new int[n][m];
        i = n - 1 - s1;
        while (i >= 0 && i < n) {
            int j = m - 1 - s2;
            while (j >= 0 && j < m) {
                if (tmp[i][j] == 1) res[i][j] = stampHeight;
                else if (i + step1 < n && i + step1 >= 0 && res[i + step1][j] > 0)
                    res[i][j] = res[i + step1][j] - 1;
                j -= step2;
            }
            i -= step1;
        }

        i = n - 1 - s1;
        while (i >= 0 && i < n) {
            int j = m - 1 - s2;
            while (j >= 0 && j < m) {
                if (res[i][j] > 0) res[i][j] = stampWidth;
                else if (j + step2 < m && j + step2 >= 0 && res[i][j + step2] > 0)
                    res[i][j] = res[i][j + step2] - 1;
                j -= step2;
            }
            i -= step1;
        }

        for (i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (res[i][j] >= 1) flag[i][j] = 1;
            }
        }
    }

    public boolean possibleToStamp(int[][] grid, int stampHeight, int stampWidth) {
        int n = grid.length;
        int m = grid[0].length;
        flag = new int[n][m];

        helper(grid, stampHeight, stampWidth, 0, 0, 1, 1);
        helper(grid, stampHeight, stampWidth, n - 1, m - 1, -1, -1);
        helper(grid, stampHeight, stampWidth, 0, m - 1, 1, -1);
        helper(grid, stampHeight, stampWidth, n - 1, 0, -1, 1);

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (flag[i][j] == grid[i][j]) return false;
            }
        }

        return true;
    }
}
