/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/12/19
 */
public class lc334 {
    public boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE;
        int big = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            if(small >= nums[i]) small = nums[i];
            else if (big >= nums[i]) big = nums[i];
            else return true;
        }
        return false;
    }
}
