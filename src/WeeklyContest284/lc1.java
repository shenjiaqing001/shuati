package WeeklyContest284;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 3/12/22
 */
public class lc1 {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == key) {
                set.add(i);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            Integer floorKey = set.floor(i);
            Integer ceilingKey = set.ceiling(i);
            if ((floorKey != null && i - floorKey <= k) ||
                    (ceilingKey != null && ceilingKey - i <= k)) {
                res.add(i);
            }
        }
        return res;
    }
}
