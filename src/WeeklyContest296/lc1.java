package WeeklyContest296;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 6/4/22
 */
public class lc1 {
    public int minMaxGame(int[] nums) {
        if (nums.length == 1) return nums[0];
        while (nums.length >= 4) {
            int n = nums.length;
            int[] a = new int[n / 2];
            for (int i = 0; i < n; i += 4) {
                a[i / 2] = Math.min(nums[i], nums[i + 1]);
                a[i / 2 + 1] = Math.min(nums[i + 2], nums[i + 3]);
            }
            nums = a;
        }
        return Math.min(nums[0], nums[1]);
    }
}
