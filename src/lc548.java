import java.util.HashSet;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/11/11
 */
public class lc548 {
    public boolean splitArray(int[] nums) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            sum[i] = sum[i - 1] + nums[i];
        }

        for (int i = 3; i < nums.length - 3; ++i) {
            HashSet<Integer> set = new HashSet<>();
            for (int j = 1; j < i - 1; ++j) {
                if (sum[j - 1] == sum[i - 1] - sum[j])
                    set.add(sum[j - 1]);
            }

            for (int k = i + 2; k < nums.length - 1; ++k) {
                if (sum[nums.length - 1] - sum[k] == sum[k - 1] - sum[i]) {
                    if (set.contains(sum[k - 1] - sum[i]))
                        return true;
                }
            }
        }
        return false;
    }
}
