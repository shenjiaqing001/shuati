/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/29
 */
public class lc1295 {
    public int findNumbers(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            int digits = 0;
            while (nums[i] > 0) {
                digits++;
                nums[i] /= 10;
            }
            if (digits % 2 == 0) res++;
        }
        return res;
    }
}
