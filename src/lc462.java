import java.util.Arrays;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/11/11
 */
public class lc462 {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int lo = 0;
        int hi = nums.length - 1;
        int mid = (lo + hi) / 2;
        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            res += Math.abs(nums[i] - nums[mid]);
        }
        return res;
    }
}
