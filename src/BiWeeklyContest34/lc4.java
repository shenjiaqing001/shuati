package BiWeeklyContest34;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/5/20
 */
public class lc4 {
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int n = locations.length;
        int[][] dis = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == j) continue;
                dis[i][j] = Math.abs(locations[i] - locations[j]);
            }
        }

        int[][] dp = new int[fuel+1][n];
        dp[fuel][start] = 1;
        for (int i = fuel; i >= 0; --i) {
            for (int j = 0; j < n; ++j) {
                if (dp[i][j] == 0) continue;
                for (int k = 0; k < n; ++k) {
                    if(j == k) continue;
                    if (i >= dis[j][k]) {
                        dp[i - dis[j][k]][k] += dp[i][j];
                        dp[i - dis[j][k]][k] %= 1000000007;
                    }
                }
            }
        }
        for(int i =fuel;i>=0;--i){
            for(int j =0;j<n;++j){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        int res = 0;
        for (int i = fuel; i >= 0; --i) {
            res += dp[i][finish];
            res %= 1000000007;
        }
        return res;
    }
}
