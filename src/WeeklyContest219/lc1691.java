package WeeklyContest219;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/12/17
 */
public class lc1691 {
    public int maxHeight(int[][] cuboids) {
        int n = cuboids.length;
        int[] dp = new int[n];
        for (int[] a : cuboids) {
            Arrays.sort(a);
        }

        Arrays.sort(cuboids, new Comparator<>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) return o2[0] - o1[0];
                if (o1[1] != o2[1]) return o2[1] - o1[1];
                return o2[2] - o1[2];
            }
        });

        int max = 0;
        for (int i = 0; i < n; ++i) {
            dp[i] = cuboids[i][2];
            for (int j = 0; j < i; ++j) {
                if (cuboids[j][0] >= cuboids[i][0] && cuboids[j][1] >= cuboids[i][1] &&
                        cuboids[j][2] >= cuboids[i][2]) {
                    dp[i] = Math.max(dp[i], dp[j] + cuboids[i][2]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
