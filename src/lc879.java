/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/11/19
 */
public class lc879 {
    public int profitableSchemes(int G, int P, int[] group, int[] profit) {
        long[][] dp = new long[G + 1][P + 1];
        dp[0][0] = 1;
        for (int i = 0; i < group.length; ++i) {
            for (int j = G; j >= 0; --j) {
                for (int k = P; k >= 0; --k) {
                    int nextG = j + group[i];
                    int nextP = k + profit[i];
                    if (nextP > P) nextP = P;
                    if (nextG <= G) {
                        dp[nextG][nextP] += dp[j][k] % 1000000007;
                    }
                }
            }
        }

        long res = 0;
        for (int i = 0; i <= G; ++i) {
            res += dp[i][P] % 1000000007;
        }

        return (int) (res % 1000000007);
    }
}
