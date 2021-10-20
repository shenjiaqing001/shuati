/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/20
 */
public class lc1049 {

    //1 <= stones.length <= 30
    //1 <= stones[i] <= 100
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        boolean[] dp = new boolean[sum / 2 + 1];
        dp[0] = true;
        for (int stone : stones) {
            for (int i = sum / 2; i >= 0; --i) {
                if (dp[i]) {
                    if (i + stone <= sum / 2) {
                        dp[i + stone] = true;
                    }
                }
            }
        }
        int min = sum;
        for (int i = sum / 2; i >= 0; --i) {
            if (dp[i]) {
                min = Math.min(Math.abs(sum - 2 * i), min);
            }
        }
        return min;
    }
}
