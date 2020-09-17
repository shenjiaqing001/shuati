/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/9/18
 */
public class lc665 {
    public boolean checkPossibility(int[] nums) {
        if (nums.length == 1 || nums.length == 2) return true;
        boolean flag = false;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i - 1] > nums[i]) {
                if (flag == true) return false;
                if (i - 2 < 0 || nums[i - 2] <= nums[i]) {
                    flag = true;
                    continue;
                }
                nums[i] = nums[i - 1];
                flag = true;
            }
        }
        return true;
    }
}
