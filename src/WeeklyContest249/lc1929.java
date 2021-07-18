package WeeklyContest249;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/10
 */
public class lc1929 {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] res = new int[2 * n];
        for (int i = 0; i < n; ++i) {
            res[i] = res[i + n] = nums[i];
        }
        return res;
    }
}
