package WeeklyContest213;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/11/1
 */
public class lc5600 {
    public String kthSmallestPath(int[] destination, int index) {
        int row = destination[0];
        int column = destination[1];
        int n = row + column;
        int k = row;
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 0; i <= n; ++i) dp[i][0] = 1;
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= k; ++j) {
                dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
            }
        }
        int top = k;
        int bottom = n;

        StringBuilder sb = new StringBuilder();
        while (index > 0) {
            System.out.println("k=" + top + ",n = " + bottom);
            if (index > dp[bottom - 1][top]) {
                index -= dp[bottom - 1][top];
                sb.append('V');
                top -= 1;
            } else {
                sb.append('H');
                bottom -= 1;
            }

            if (top == 0) {
                for (int i = 0; i < bottom; ++i) sb.append('H');
                break;
            }
            if (top == bottom) {
                for (int i = 0; i < top; ++i) sb.append('V');
            }
        }
        return sb.toString();
    }


}
