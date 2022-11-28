package WeeklyContest302;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/16/22
 */
public class lc1 {
    public int[] numberOfPairs(int[] nums) {
        int[] count = new int[101];
        for (int n : nums) {
            count[n]++;
        }
        int res0 = 0;
        int res1 = 0;
        for (int i = 0; i <= 100; ++i) {
            res0 += count[i] / 2;
            res1 += count[i] % 2;
        }
        return new int[]{res0, res1};
    }
}
