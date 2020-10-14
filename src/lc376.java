/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/15
 */
public class lc376 {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) return nums.length;
        boolean flag = true;
        int res = 1;
        boolean start = false;
        for (int i = 1; i < nums.length; ++i) {
            if (start == false) {
                if (nums[i] == nums[i - 1]) continue;
                else {
                    if (nums[i] > nums[i - 1]) {
                        flag = true;
                    } else {
                        flag = false;
                    }
                    res++;
                    start = true;
                }
            } else {
                if (flag == true) {
                    if (nums[i] >= nums[i - 1]) {
                    } else {
                        flag = false;
                        res++;
                    }
                } else {
                    if (nums[i] <= nums[i - 1]) {
                    } else {
                        flag = true;
                        res++;
                    }
                }
            }
        }
        return res;
    }
}
