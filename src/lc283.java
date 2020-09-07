/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/8/20
 */
public class lc283 {
    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;

        while (right < nums.length) {
            if (nums[right] == 0) {
                right++;
                continue;
            } else {
                if (right == left) {
                    left++;
                    right++;
                    continue;
                }

                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
                right++;
            }
        }
    }
}
