package WeeklyContest285;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 3/19/22
 */
public class lc1 {
    public int countHillValley(int[] nums) {
        int res = 0;
        int n = nums.length;
        int trend = 0;
        List<Integer> list = new ArrayList<>();
        int last = -1;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != last) {
                list.add(nums[i]);
            }
            last = nums[i];
        }

        for (int i = 1; i < list.size() - 1; ++i) {
            if (list.get(i) < list.get(i + 1) && list.get(i) < list.get(i - 1)) {
                res++;
            } else if (list.get(i) > list.get(i + 1) && list.get(i) > list.get(i - 1)) {
                res++;
            }
        }
        return res;
    }
}
