package WeeklyContest242;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/5/22
 */
public class lc4 {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += stones[i];
        }

        int max = sum;
        for (int i = n - 1; i >= 2; --i) {
            sum -= stones[i];
            max = Math.max(max, sum - max);
        }
        return max;
    }

}
