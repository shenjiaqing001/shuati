import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/8/22
 */
public class lc1713 {
    public int minOperations(int[] target, int[] arr) {
        int n = target.length;
        int m = arr.length;
        int[][] dp = new int[n + 1][m + 1];
        int max = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (target[i] == arr[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
                max = Math.max(max, dp[i + 1][j + 1]);
            }
        }
        return n - max;
    }

    public int LIS(int[] nums, int n) {
        int[] lis = new int[n];
        int size = 0;
        for (int i = 0; i < n; ++i) {
            int lo = 0;
            int hi = size;

            while (lo < hi) {
                int mid = (lo + hi) / 2;
                if (lis[mid] < nums[i])
                    lo = mid + 1;
                else
                    hi = mid;
            }
            lis[lo] = nums[i];
            if (lo == size) size++;
        }
        return size;
    }

    public int minOperations2(int[] target, int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < target.length; ++i) {
            map.put(target[i], i);
        }

        int[] nums = new int[n];
        int index = 0;
        for (int num : arr) {
            if (map.containsKey(num)) {
                nums[index++] = map.get(num);
            }
        }
        int size = LIS(nums, index);
        return target.length - size;
    }


}
