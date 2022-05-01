package WeeklyContest280;

import javax.swing.*;
import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2/12/22
 */
public class lc4 {

    public int maximumANDSum3(int[] nums, int numSlots) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        while (list.size() < 2 * numSlots) list.add(0);

        int max = 0;
        for (int i = 0; i < 5000; ++i) {
            Collections.shuffle(list);
            int sum = 0;
            for (int j = 0; j < numSlots; ++j) {
                sum += (list.get(2 * j) & (j + 1)) + (list.get(2 * j + 1) & (j + 1));
            }
            max = Math.max(max, sum);
        }
        return max;
    }


    public int maximumANDSum(int[] nums, int numSlots) {
        int state = 1;
        for (int i = 0; i < numSlots; ++i) {
            state *= 3;
        }
        int[] dp = new int[state];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
        int max = 0;
        for (int i = 0; i < nums.length; ++i) {
            for (int tmpState = state - 1; tmpState >= 0; tmpState--) {
                if (dp[tmpState] < 0) continue;
                int bit = numSlots;
                int base = 1;
                int tmp = tmpState;
                for (int k = 0; k < numSlots; ++k) {
                    int remain = tmp % 3;
                    if (remain < 2) {
                        dp[tmpState + base] =
                                Math.max(dp[tmpState + base], dp[tmpState] + (bit & nums[i]));
                        max = Math.max(max, dp[tmpState + base]);
                    }
                    tmp /= 3;
                    bit--;
                    base *= 3;
                }
            }
        }
        return max;
    }

    Map<Integer, Integer> map = new HashMap<>();
    int max = 0;

    public int maximumANDSum2(int[] nums, int numSlots) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length / 2; ++i) {
            int tmp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = tmp;
        }
        int state = 1;
        for (int i = 0; i < numSlots; ++i) {
            state *= 3;
        }
        state -= 1;
        int[] sums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; ++i) {
            sums[i + 1] = sums[i] + nums[i];
        }
        return dfs(nums, sums, state, 0, 0, numSlots);
    }

    int dfs(int[] nums, int[] sums, int state, int sum, int index, int numSlots) {
        if (index == nums.length) {
            max = Math.max(max, sum);
            return sum;
        }
        if (map.containsKey(state) && sum + sums[nums.length] - sums[index] <= map.get(state))
            return map.get(state);
        int bit = numSlots;
        int base = 1;
        int tmp = 0;
        int t = state;
        while (t > 0) {
            int remain = t % 3;
            if (remain > 0) {
                int next = state - base;
                tmp = Math.max(tmp, dfs(nums, sums, next, sum + (bit & nums[index]), index + 1,
                        numSlots));
            }
            bit--;
            base *= 3;
            t /= 3;
        }
        map.put(state, tmp);
        return tmp;
    }
    //[15,13,4,4,11,6,6,12,15,7,3,12,13,7]
    //8



    public static void main(String[] args) {
        lc4 test = new lc4();
        test.maximumANDSum(new int[]{1, 2, 3, 4, 5, 6}, 3);
    }

}
