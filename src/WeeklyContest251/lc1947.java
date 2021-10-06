package WeeklyContest251;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/24
 */
public class lc1947 {
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        // m 学生数量
        int m = students.length;
        // n 问题数量
        int n = students[0].length;

        int[][] dp = new int[m][m];

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < m; ++j) {
                for (int k = 0; k < n; ++k) {
                    if (students[i][k] == mentors[j][k]) dp[i][j]++;
                }
            }
        }
        boolean[] flag = new boolean[m];
        return dfs(dp, 0, flag);
    }

    public int dfs(int[][] dp, int index, boolean[] flag) {
        if (index == dp.length) return 0;
        int max = 0;
        for (int i = 0; i < dp.length; ++i) {
            if (flag[i]) continue;
            flag[i] = true;
            max = Math.max(max, dp[index][i] + dfs(dp, index + 1, flag));
            flag[i] = false;
        }
        return max;
    }
}
