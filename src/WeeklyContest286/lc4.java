package WeeklyContest286;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 3/26/22
 */
public class lc4 {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        List<List<Integer>> sums = new ArrayList<>();
        for (List<Integer> pile : piles) {
            List<Integer> tmp = new ArrayList<>();
            int sum = 0;
            tmp.add(sum);
            for (int num : pile) {
                sum += num;
                tmp.add(sum);
            }
            sums.add(tmp);
        }
        System.out.println(sums);
        int[] dp = new int[k + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (List<Integer> sum : sums) {
            for (int i = dp.length -1; i >=0; --i) {
                if (dp[i] == -1) continue;
                for (int j = sum.size() - 1; j >=0; --j) {
                    if (i + j > k) continue;
                    dp[i + j] = Math.max(dp[i+j], dp[i] + sum.get(j));
                }
            }
        }
        return dp[k];
    }

    public static void main(String[] args) {
        lc4 test = new lc4();
    }
}
