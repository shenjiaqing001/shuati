package WeeklyContest277;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 1/22/22
 */
public class lc2 {
    public int[] rearrangeArray(int[] nums) {
        List<Integer> p = new ArrayList<>();
        List<Integer> n = new ArrayList<>();
        for (int num : nums) {
            if (num > 0) p.add(num);
            else n.add(num);
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i += 2) {
            res[i] = p.get(i / 2);
            res[i + 1] = n.get(i / 2);
        }
        return res;
    }
}
