/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/9/18
 */
public class lc300 {

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int size = 0;
        for (int i = 0; i < nums.length; ++i) {
            int now = nums[i];
            int lo = 0;
            int hi = size;
            while (lo != hi) {
                int mid = (lo + hi) / 2;
                if (now <= dp[mid]) hi = mid;
                else lo = mid + 1;
            }
            dp[lo] = now;
            if (lo == size) size++;
        }
        return size;
    }

}
