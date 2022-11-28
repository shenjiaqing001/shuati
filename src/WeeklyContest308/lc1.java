package WeeklyContest308;

import java.util.Arrays;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/27/22
 */
public class lc1 {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int n = queries.length;
        int[] res = new int[n];
        for (int i = 0; i < queries.length; ++i) {
            int sum = 0;
            int j = 0;
            while (j < nums.length && sum + nums[j] <= queries[i]) {
                sum += nums[j];
                j++;

            }
            res[i] = j;
        }
        return res;
    }
}
