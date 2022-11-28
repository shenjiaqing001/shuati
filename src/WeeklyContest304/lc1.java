package WeeklyContest304;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/30/22
 */
public class lc1 {
    public int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        if (set.contains(0)) return set.size() - 1;
        else return set.size();
    }
}
