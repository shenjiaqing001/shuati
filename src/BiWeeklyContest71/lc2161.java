package BiWeeklyContest71;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2/10/22
 */
public class lc2161 {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> smaller = new ArrayList<>();
        List<Integer> larger = new ArrayList<>();
        int equal = 0;
        for (int num : nums) {
            if (num == pivot) {
                equal++;
            } else if (num < pivot) {
                smaller.add(num);
            } else {
                larger.add(num);
            }
        }
        int[] res = new int[nums.length];
        int index = 0;
        for (int num : smaller) {
            res[index++] = num;
        }
        for (int i = 0; i < equal; i++) {
            res[index++] = pivot;
        }
        for (int num : larger) {
            res[index++] = num;
        }
        return res;
    }
}
