package WeeklyContest312;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/24/22
 */
public class lc2 {
    public int longestSubarray(int[] nums) {
        int maxNum = -1;
        int count = 0;
        int res = 1;
        for (int num : nums) {
            if (num == maxNum) {
                count++;
            } else {
                if (num < maxNum) {
                    count = 0;
                } else {
                    maxNum = num;
                    count = 1;
                    res = 1;
                }
            }
            res = Math.max(res, count);
        }
        return res;
    }
}
