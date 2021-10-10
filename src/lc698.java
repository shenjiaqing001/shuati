import java.util.HashSet;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/9/30
 */
public class lc698 {
    public static void main(String[] args) {
        lc698 test = new lc698();
        test.canPartitionKSubsets(new int[]{2, 2, 2, 2, 3, 4, 5}, 4);
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int n = nums.length;
        if (sum % k != 0) return false;
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= (1 << n) - 1; ++i) {
            int num = 0;
            for (int j = 0; j < n; ++j) {
                if (((i >> j) & 1) > 0) num += nums[j];
            }
            if (num == sum / k) {
                set.add(i);
            }
        }
        return dfs(set, 0, k);
    }

    public boolean dfs(Set<Integer> set, int digits, int k) {
        if (k == 0) return true;
        for (int digit : set) {
            if ((digit & digits) == 0) {
                digits ^= digit;
                if (dfs(set, digits, k - 1)) return true;
                digits ^= digit;
            }
        }
        return false;
    }
}
