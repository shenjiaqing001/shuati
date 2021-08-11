/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/9/18
 */
public class lc300 {
    public int lengthOfLIS(int[] nums) {
        int[] lis = new int[nums.length];
        int size = 0;
        for (int num : nums) {
            int lo = 0;
            int hi = size;

            while (lo < hi) {
                int mid = (lo + hi) / 2;
                if (lis[mid] < num)
                    lo = mid + 1;
                else
                    hi = mid;
            }
            lis[lo] = num;
            if (lo == size) size++;

        }
        return size;
    }

    public int lengthOfLIS2(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int res = 0;

        for (int i = 0; i < n; ++i) {
            int max = 0;
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i]) max = Math.max(max, dp[j]);
            }
            dp[i] = max + 1;
            res = Math.max(res, dp[i]);
        }
        return res;
    }

}
