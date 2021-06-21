/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/6/17
 */
public class lc795 {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {

        int j = 0;
        int res = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= left && nums[i] <= right) {
                res += i - j + 1;
                count = i - j + 1;
            } else if (nums[i] < left) {
                res += count;
            } else {
                j = i + 1;
                count = 0;
            }
        }
        return res;

    }
}
