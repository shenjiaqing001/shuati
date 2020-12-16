import java.util.Arrays;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/12/16
 */
public class lc977 {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            res[i] = nums[i] * nums[i];
        }
        Arrays.sort(res);
        return res;
    }
}
