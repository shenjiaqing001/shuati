package WeeklyContest227;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/2/7
 */
public class lc1 {
    public boolean check(int[] nums) {
        boolean flag = false;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] < nums[i - 1]) {
                if (flag == true) return false;
                else flag = true;
            }
        }

        int n = nums.length;
        if (nums[n - 1] > nums[0]) {
            if (flag == true) return false;
        }
        return true;
    }
}
