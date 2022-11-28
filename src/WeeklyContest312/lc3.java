package WeeklyContest312;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/24/22
 */
public class lc3 {
    public List<Integer> goodIndices(int[] nums, int k) {
        Set<Integer> decreasing = new HashSet<>();
        Set<Integer> increasing = new HashSet<>();
        if (k == 1) {
            for (int i = 1; i < nums.length - 1; ++i) {
                decreasing.add(i);
                increasing.add(i);
            }
        }
        int count = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] <= nums[i - 1]) {
                count++;
            } else {
                count = 1;
            }
            if (count >= k) {
                decreasing.add(i + 1);
            }
        }
        count = 1;
        for (int i = nums.length - 2; i >= 0; --i) {
            if (nums[i] <= nums[i + 1]) {
                count++;
            } else {
                count = 1;
            }
            if (count >= k) {
                increasing.add(i - 1);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            if (decreasing.contains(i) && increasing.contains(i)) {
                res.add(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        lc3 test = new lc3();
        test.goodIndices(
                new int[]{323173, 979246, 174252, 460371, 587394, 246910, 349172, 212556, 876991, 521409, 321842, 78068, 40003, 33668, 7118, 4017, 483, 479, 160, 21, 10, 6, 4, 3, 2, 1, 1, 1, 1, 1, 1, 1, 1, 712017, 790290, 815568, 982502, 997694, 999434, 999925, 999973, 999977, 999982, 999998, 1000000, 1000000, 1000000, 1000000, 1000000, 1000000, 1000000, 1000000, 1000000, 1000000, 1000000, 1000000, 1000000, 1000000},
                25);
    }
}
