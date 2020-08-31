/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/19/20
 */
public class lc189 {
    public void rotate(int[] nums, int k) {
        if (nums.length == 1) return;
        if (nums.length == 0) return;

        k %= nums.length;
        if (k == 0) return;

        rotateSection(nums, 0, nums.length - 1);
        rotateSection(nums, 0, k - 1);
        rotateSection(nums, k, nums.length - 1);
    }


    public void rotateSection(int[] nums, int left, int right) {
        while (left < right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
    }
}
