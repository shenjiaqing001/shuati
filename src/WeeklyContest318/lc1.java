package WeeklyContest318;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 11/5/22
 */
public class lc1 {
    public int[] applyOperations(int[] nums) {
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }
        int[] res = new int[nums.length];
        int index = 0;
        for (int num : nums) {
            if (num != 0) {
                res[index++] = num;
            }
        }
        return res;
    }


}
