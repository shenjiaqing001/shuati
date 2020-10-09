/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/9
 */
public class lc1413 {
    public int minStartValue(int[] nums) {
        int sum = 0;
        int min = 1;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            min = Math.min(min, sum);
        }

        if (min == 1) return 1;
        else return 1 - min;
    }
}
