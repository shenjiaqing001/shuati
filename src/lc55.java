/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/3
 */
public class lc55 {
    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (max < i) return false;
            max = Math.max(max, i + nums[i]);
        }
        return true;
    }
}
