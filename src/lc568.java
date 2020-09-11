/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/12/20
 */
public class lc568 {
    public int maxVacationDays(int[][] flights, int[][] days) {
        int cities = flights.length;
        int weeks = days[0].length;
        int[][] dp = new int[weeks][cities];

        return dfs(flights, days, dp, 0, 0);
    }

    public int dfs(int[][] flights, int[][] days, int[][] dp, int week, int city) {
        if (week == days[0].length) return 0;
        if (dp[week][city] != 0) return dp[week][city];

        int max = days[city][week];
        for (int i = 0; i < flights.length; ++i) {
            if (flights[city][i] != 0 || i == city) {
                max = Math.max(max, dfs(flights, days, dp, week + 1, i) + days[i][week]);
            }
        }
        dp[week][city] = max;
        return max;
    }
}
