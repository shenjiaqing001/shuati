package WeeklyContest321;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 11/26/22
 */
public class lc4 {
    public int countSubarrays(int[] nums, int k) {
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == k) {
                index = i;
                break;
            }
        }
        Map<Integer, Integer> left = new HashMap<>();
        left.put(0, 1);
        int count = 0;
        // 大++，小--.
        for (int i = index - 1; i >= 0; --i) {
            if (nums[i] > k) count++;
            else count--;
            left.put(count, left.getOrDefault(count, 0) + 1);
        }
        count = 0;
        int res = 0;
        res += left.getOrDefault(count, 0);
        res += left.getOrDefault(count + 1, 0);

        for (int i = index + 1; i < nums.length; i++) {
            if (nums[i] > k) count++;
            else count--;
            res += left.getOrDefault(-count, 0);
            res += left.getOrDefault(-count + 1, 0);
        }
        return res;
    }

    public int countSubarrays2(int[] nums, int k) {
        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == k) {
                pos = i;
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;
        for (int i = pos - 1; i >= 0; --i) {
            if (nums[i] > k) {
                count += 1;
            } else {
                count -= 1;
            }
            map.put(count, map.getOrDefault(count, 0) + 1);
        }
        int count1 = 0;
        int res = 0;
        res += map.getOrDefault(0, 0);
        res += map.getOrDefault(1, 0);

        for (int i = pos + 1; i < nums.length; i++) {
            if (nums[i] > k) {
                count1 -= 1;
            } else {
                count1 += 1;
            }
            res += map.getOrDefault(count1, 0);
            res += map.getOrDefault(count1 + 1, 0);
        }
        return res;
    }
}
