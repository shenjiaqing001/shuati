package WeeklyContest303;

import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/23/22
 */
public class lc4 {
    public long countExcellentPairs(int[] nums, int k) {
        if (k == 60) return 0;
        long res = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int num : set) {
            int count = Integer.bitCount(num);
            if (count * 2 >= k) res++;
        }
        int[] counts = new int[set.size()];
        int i = 0;
        for (int num : set) {
            int count = Integer.bitCount(num);
            counts[i++] = count;
        }
        Arrays.sort(counts);
        int last = counts[counts.length - 1];
        for (i = 0; i < counts.length; ++i) {
            if (counts[i] + last < k) continue;
            int lo = 0;
            int hi = counts.length - 1;
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                int c = counts[i] + counts[mid];
                if (c < k) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            int tmp = counts.length - lo;
            if (i >= lo) tmp--;
            res += (long) tmp;
        }
        return res;
    }

    public static void main(String[] args) {
        lc4 test = new lc4();
        test.countExcellentPairs(new int[]{1, 2, 3, 1}, 3);
    }
}
