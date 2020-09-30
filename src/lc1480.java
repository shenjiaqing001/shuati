/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/1
 */
public class lc1480 {
    public int[] runningSum(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            nums[i] = sum;
        }
        return nums;
    }
}
