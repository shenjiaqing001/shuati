/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/9/2
 */
public class lc565 {
    public int arrayNesting(int[] nums) {
        int max = 0;

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == -1) continue;
            int size = 0;
            int now = i;
            while (nums[now] != -1) {
                size++;
                int tmp = now;
                now = nums[now];
                nums[tmp] = -1;
            }
            max = Math.max(max, size);
        }
        return max;
    }
}
