package WeeklyContest315;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 10/15/22
 */
public class lc1 {
    public int findMaxK(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (num < 0) set.add(num);
        }
        int max = -1;
        for (int num : nums) {
            if (num > 0) {
                if (set.contains(-num)) {
                    max = Math.max(max, num);
                }
            }
        }
        return max;
    }

}
