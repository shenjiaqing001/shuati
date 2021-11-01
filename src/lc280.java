/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/11/1
 */
public class lc280 {
    public void wiggleSort(int[] nums) {
        boolean flag = false;
        for (int i = 0; i < nums.length - 1; ++i) {
            if (flag) {
                if (nums[i] < nums[i + 1]) {
                    swap(nums, i, i + 1);
                }
            } else {
                if (nums[i] > nums[i + 1]) {
                    swap(nums, i, i + 1);
                }
            }
            flag = !flag;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
