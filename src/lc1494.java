import java.util.Arrays;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/9/6
 */
public class lc1494 {


    public static void main(String[] args) {
        lc1494 test = new lc1494();
        test.minNumberOfSemesters(5, new int[][]{{2, 1}, {3, 1}, {4, 1}, {1, 5}}, 2);

    }

    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        int[] dp = new int[1 << n];
        Arrays.fill(dp, n);
        int[] preCourses = new int[n];
        for (int[] relation : relations) {
            preCourses[relation[1] - 1] |= 1 << (relation[0] - 1);
        }

        dp[0] = 0;
        for (int state = 0; state < (1 << n); state++) {
            int preState = 0;
            for (int i = 0; i < n; i++) {
                if (((state >> i) & 1) > 0)
                    preState |= preCourses[i];
            }
            if (preState == 0 && Integer.bitCount(state) <= k)
                dp[state] = 1;
            for (int subset = state; subset > 0; subset = (subset - 1) & state) {
                if (Integer.bitCount(state) - Integer.bitCount(subset) <= k &&
                        (preState & subset) == preState) {
                    dp[state] = Math.min(dp[state], dp[subset] + 1);
                }
            }
        }

        return dp[(1 << n) - 1];
    }
}
