package WeeklyContest320;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 11/19/22
 */
public class lc1 {
    public int unequalTriplets(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] != nums[j] && nums[i] != nums[k] && nums[j] != nums[k]) {
                        res++;
                    }
                }
            }
        }
        return res;
    }


}
