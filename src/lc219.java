import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/4/16
 */
public class lc219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        if (k > nums.length) k = nums.length;
        for (int i = 0; i < k; ++i) {
            if (set.contains(nums[i])) return true;
            else set.add(nums[i]);
        }

        if (k == nums.length) return false;
        if (set.contains(nums[k])) return true;
        set.add(nums[k]);

        for (int i = k + 1; i < nums.length; ++i) {
            set.remove(nums[i - k - 1]);
            if (set.contains(nums[i])) return true;
            else set.add(nums[i]);
        }
        return false;
    }
}
