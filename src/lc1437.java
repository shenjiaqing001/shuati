/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/1/26
 */
public class lc1437 {
    public boolean kLengthApart(int[] nums, int k) {
        int last = 0 - 1 - k;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 1) {
                if (i - last <= k) return false;
                last = i;
            }
        }
        return true;
    }
}
