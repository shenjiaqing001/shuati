package WeeklyContest280;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2/12/22
 */
public class lc2 {
    public int minimumOperations(int[] nums) {
        if (nums.length == 1) return 0;
        Map<Integer, Integer> odd = new HashMap<>();
        Map<Integer, Integer> even = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (i % 2 == 0) {
                even.put(nums[i], even.getOrDefault(nums[i], 0) + 1);
            } else {
                odd.put(nums[i], odd.getOrDefault(nums[i], 0) + 1);
            }
        }
        int[][] odds = new int[odd.size()][];
        int[][] evens = new int[even.size()][];
        int index = 0;
        for (int key : odd.keySet()) {
            odds[index++] = new int[]{key, odd.get(key)};
        }
        index = 0;
        for (int key : even.keySet()) {
            evens[index++] = new int[]{key, even.get(key)};
        }
        Arrays.sort(odds, (o1, o2) -> (o2[1] - o1[1]));
        Arrays.sort(evens, (o1, o2) -> (o2[1] - o1[1]));
        if (odds[0][0] != evens[0][0]) {
            return nums.length - odds[0][1] - evens[0][1];
        } else {
            if (odds.length >= 2 && evens.length >= 2) {
                return Math.min(nums.length - odds[1][1] - evens[0][1],
                        nums.length - odds[0][1] - evens[1][1]);
            } else if (odds.length >= 2 && evens.length < 2) {
                return nums.length - odds[1][1] - evens[0][1];
            } else if (odds.length < 2 && evens.length >= 2) {
                return nums.length - odds[0][1] - evens[1][1];
            } else {
                return Math.min(odds[0][1], evens[0][1]);
            }
        }
    }
}
