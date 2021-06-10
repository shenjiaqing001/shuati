package WeeklyContest235;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/4/28
 */
public class lc1818 {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int res = 0;
        int gain = 0;
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        for (int i = 0; i < nums1.length; ++i) {
            res = (res + Math.abs(nums1[i] - nums2[i])) % 1_000_000_007;

            if (nums1[i] != nums2[i]) {
                Integer ceil = set.ceiling(nums2[i]);
                Integer floor = set.floor(nums2[i]);

                int diff = Math.abs(nums1[i] - nums2[i]);

                if (ceil != null) {
                    int val1 = Math.abs(ceil - nums2[i]);
                    gain = Math.max(gain, diff - val1);
                }

                if (floor != null) {
                    int val2 = Math.abs(floor - nums2[i]);
                    gain = Math.max(gain, diff - val2);
                }
            }
        }
        return (res + 1_000_000_007 - gain) % 1_000_000_007;
    }
}
