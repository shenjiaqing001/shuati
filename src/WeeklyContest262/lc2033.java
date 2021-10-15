package WeeklyContest262;

import java.util.Arrays;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/9
 */
public class lc2033 {
    public int minOperations(int[][] grid, int x) {
        int n = grid.length;
        int m = grid[0].length;
        int[] nums = new int[n * m];
        int index = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                nums[index++] = grid[i][j];
            }
        }
        Arrays.sort(nums);
        for (int i = 1; i < n * m; ++i) {
            if ((nums[i] - nums[0]) % x != 0) return -1;
            nums[i] = (nums[i] - nums[0]) / x;
        }
        nums[0] = 0;
        int sum = 0;
        for (int i = 1; i < n * m; ++i) {
            sum += nums[i];
        }
        int min = sum;

        for (int i = 1; i < n * m; ++i) {
            int left = i;
            int right = n * m - i;
            sum += left * (nums[i] - nums[i - 1]) - right * (nums[i] - nums[i - 1]);
            min = Math.min(min, sum);
        }
        return min;
    }
}
