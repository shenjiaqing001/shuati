package WeeklyContest283;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 3/5/22
 */
public class lc2 {
    public long minimalKSum(int[] nums, int k) {
        long res = 0;
        long last = 0;
        int index = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        nums = new int[set.size()];
        int tmp = 0;
        for (int num : set) nums[tmp++] = num;
        Arrays.sort(nums);
        for (int num : nums) System.out.print(num + " ");

        while (k > 0) {
            if (index < nums.length) {
                long howMany = (nums[index] - 1 - last);
                howMany = Math.min(howMany, k);
                res += (long) (last + 1 + last + howMany) * howMany / 2;
                k -= howMany;
                last = nums[index];
                index++;
            } else {
                res += (long) (nums[nums.length - 1] + 1 + nums[nums.length - 1] + k) * k / 2;
                k = 0;
            }
        }
        return res;
    }
}
