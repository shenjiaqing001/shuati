package WeeklyContest221;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/12/27
 */
public class lc1706 {
    public int[] findBall(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] ball = new int[m];
        for (int i = 0; i < m; ++i) ball[i] = i;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (ball[j] != -1) {
                    int pos = ball[j];
                    if (pos == 0 && grid[i][pos] == -1) ball[j] = -1;
                    else if (pos == m - 1 && grid[i][pos] == 1) ball[j] = -1;
                    else {
                        if (grid[i][pos] == 1) {
                            if (grid[i][pos + 1] == 1) ball[j]++;
                            else ball[j] = -1;
                        } else {
                            if (grid[i][pos - 1] == -1) ball[j]--;
                            else ball[j] = -1;
                        }
                    }
                }
            }
        }
        return ball;
    }
}
