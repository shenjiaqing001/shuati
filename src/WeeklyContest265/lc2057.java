package WeeklyContest265;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/30
 */
public class lc2057 {
    public int smallestEqual(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            if (i % 10 == nums[i]) return i;
        }
        return -1;
    }
}
