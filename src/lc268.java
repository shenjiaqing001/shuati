/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/1/20
 */
public class lc268 {
    public int missingNumber(int[] nums) {
        int missing = -1;

        int left = 0;
        while (left < nums.length) {
            if (left == nums[left]) {
                left++;
                continue;
            }

            int tmp = nums[left];
            if (tmp == nums.length) {
                missing = left;
                nums[left] = -1;
                left++;
            } else if (tmp == -1) {
                missing = left;
                left++;
            } else {
                nums[left] = nums[tmp];
                nums[tmp] = tmp;
            }
        }

        if (missing == -1) return nums.length;
        else return missing;
    }
}
