package WeeklyContest254;

import java.util.Arrays;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/8/14
 */
public class lc1968 {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int[] res = new int[n];
        int left = 0;
        int right = n - 1;
        int index = 0;
        boolean flag = false;
        while (left <= right) {
            if (flag) {
                res[index++] = nums[right--];
            } else {
                res[index++] = nums[left++];
            }
            flag = !flag;
        }
        return res;
    }
}
