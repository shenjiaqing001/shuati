package WeeklyContest255;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/8/21
 */
public class lc1980 {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        Set<String> set = new HashSet<>();
        Collections.addAll(set, nums);
        int max = 1;
        for (int i = 0; i < n; ++i) max *= 2;
        max -= 1;
        String res = "";
        for (int i = max; i >= 0; --i) {
            String s = Integer.toBinaryString(i);
            if (!set.contains(s)) {
                res = s;
                break;
            }
        }
        while (res.length() < n) res = "0" + res;
        return res;
    }
}
