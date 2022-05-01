package WeeklyContest291;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 4/30/22
 */
public class lc3 {
    public int count(int[] nums, int length, int k, int p) {
        Set<Long> set = new HashSet<>();
        int count = 0;
        long base = 201;
        long power = 1;
        long hash = 0;
        for (int i = 0; i < length; ++i) {
            power *= base;
        }

        for (int i = 0; i < nums.length; ++i) {
            hash *= base;
            hash += nums[i];
            if (nums[i] % p == 0) count++;
            if (i >= length) {
                hash -= power * nums[i - length];
                if (nums[i - length] % p == 0) count--;
            }
            if (i >= length - 1 && count <= k) set.add(hash);
        }
        return set.size();
    }

    public int countDistinct(int[] nums, int k, int p) {
        int res = 0;
        for (int i = 1; i < nums.length; ++i) {
            res += count(nums, i, k, p);
        }
        return res;
    }

    public static void main(String[] args) {
        lc3 test = new lc3();
        test.countDistinct(new int[]{2, 3, 3, 2, 2}, 2, 2);
    }

}
