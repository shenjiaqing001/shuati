package WeeklyContest279;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2/5/22
 */
public class lc1 {

    public int[] sortEvenOdd(int[] nums) {
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            if (i % 2 == 0) even.add(nums[i]);
            else odd.add(nums[i]);
        }
        odd.sort((o1, o2) -> o2 - o1);
        even.sort((o1, o2) -> o1 - o2);
        int[] res = new int[nums.length];
        for (int i = 0; i < res.length; ++i) {
            if (i % 2 == 0) res[i] = even.get(i / 2);
            else res[i] = odd.get(i / 2);
        }
        return res;
    }
}
