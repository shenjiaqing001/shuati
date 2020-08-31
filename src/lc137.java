/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/8/20
 */
public class lc137 {
    public int singleNumber(int[] nums) {
        int ones = 0;
        int twos = 0;

        for (int i = 0; i < nums.length; ++i) {
            ones = (ones ^ nums[i]) & ~twos;
            twos = (twos ^ nums[i]) & ~ones;
        }

        return ones;
    }
}
