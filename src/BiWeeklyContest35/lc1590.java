package BiWeeklyContest35;

import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/9/19
 */
public class lc1590 {
    public int minSubarray(int[] nums, int p) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] dp = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            nums[i] %= p;
            sum += nums[i];
            sum %= p;
        }
        map.put(0, -1);
        if (sum == 0) return 0;

        int min = Integer.MAX_VALUE;
        int tmp = 0;

        for (int i = 0; i < nums.length; ++i) {
            tmp += nums[i];
            tmp %= p;
            int remain = (tmp + p - sum) % p;
            System.out.println(tmp + " " + sum);
            if (map.containsKey(remain)) {
                min = Math.min(i - map.get(remain), min);
            }
            map.put(tmp, i);
        }

        if (min == Integer.MAX_VALUE) return -1;
        else if (min == nums.length) return -1;
        else return min;
    }

    public static void main(String[] args) {
        System.out.println((-1) % 3);
    }
}
