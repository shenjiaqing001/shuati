/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/13/20
 */
public class lc674 {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) return 0;
        int res = 1;
        int last = nums[0];
        int max = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] > last) {
                res++;
                max = Math.max(max, res);
            } else {
                res = 1;
            }
            last = nums[i];
        }

        return max;
    }
}
