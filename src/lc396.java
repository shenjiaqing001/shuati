/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/6/28
 */
public class lc396 {
    public int maxRotateFunction(int[] nums) {
        long init = 0;
        long sum = 0;
        int n = nums.length;
        for (int i = 0; i < nums.length; ++i) {
            init += i * nums[i];
            sum += nums[i];
        }

        long max = init;
        for (int i = 0; i < nums.length; ++i) {
            init += n * nums[i] - sum;
            max = Math.max(max, init);
            System.out.println(init);
        }
        return (int) init;
    }
}
