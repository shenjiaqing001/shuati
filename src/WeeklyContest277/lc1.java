package WeeklyContest277;

import java.util.Arrays;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 1/22/22
 */
public class lc1 {
    public int countElements(int[] nums) {
        Arrays.sort(nums);
        if (nums[0] == nums[nums.length - 1]) return 0;
        int left = 1;
        int right = nums.length - 2;
        while (nums[left] == nums[left - 1]) {
            left++;
        }
        while (nums[right] == nums[right + 1]) {
            right--;
        }
        if (left >= right) return 0;
        else return right - left + 1;
    }
}
