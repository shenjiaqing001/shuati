/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/9
 */
public class lc689 {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int length = nums.length - k + 1;
        int[] array = new int[length];
        int tmp = 0;
        for (int i = 0; i < k; ++i) {
            tmp += nums[i];
        }
        array[0] = tmp;
        for (int i = 1; i < array.length; ++i) {
            array[i] = array[i - 1] - nums[i - 1] + nums[i + k - 1];
        }
        for (int i = 0; i < array.length; ++i) System.out.print(array[i] + " ");
        System.out.println();

        int[][] dp = new int[length][3];
        dp[0][0] = array[0];
        for (int i = 1; i < length; ++i)
            dp[i][0] = Math.max(dp[i - 1][0], array[i]);

        for (int i = 1; i < 3; ++i) {
            for (int j = i * k; j < length; ++j) {
                dp[j][i] = Math.max(dp[j - 1][i], dp[j - k][i - 1] + array[j]);
            }
        }

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < length; ++j) {
                System.out.print(dp[j][i] + " ");
            }
            System.out.println();
        }

        int[] res = new int[3];
        int now = 2;
        int pos = length - 1;
        System.out.println(dp[pos][now]);
        while (true) {
            if (pos == 0) {
                res[now] = 0;
                break;
            }
            if (dp[pos][now] != dp[pos - 1][now]) {
                res[now] = pos;
                now--;
                pos -= k;
            }
            else{
                pos--;
            }
            if (pos <= -1 || now <0) break;
        }
        return res;
    }
}
