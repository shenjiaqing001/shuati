import java.util.TreeSet;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/2/20
 */
public class lc220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k < 1 || t < 0) return false;
        TreeSet<Long> values = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            long num = nums[i];
            Long floor = values.floor(num + t);
            Long ceil = values.ceiling(num - t);
            if ((floor != null && floor >= num) || (ceil != null && ceil <= num))
                return true;

            values.add(num);
            if (i >= k)
                values.remove((long) (nums[i - k]));
        }
        return false;
    }
}
