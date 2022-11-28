package WeeklyContest315;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 10/15/22
 */
public class lc2 {
    public int countDistinctIntegers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
            int tmp = num;
            int res = 0;
            while (tmp > 0) {
                res *= 10;
                res += tmp % 10;
                tmp /= 10;
            }
            set.add(res);
        }
        return set.size();
    }
}
