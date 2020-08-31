/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/8/20
 */
public class lc136 {
    public int singleNumber(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            res ^= nums[i];
        }
        return res;
    }
}
