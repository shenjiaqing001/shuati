import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/11/18
 */
public class lc1655 {
    public boolean canDistribute(int[] nums, int[] quantity) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int[] count = new int[map.size()];
        int tmp = 0;
        for (Integer key : map.keySet()) {
            count[tmp++] = map.get(key);
        }
        Arrays.sort(count);
        Arrays.sort(quantity);
        return dfs(count, quantity, quantity.length - 1);
    }

    public boolean dfs(int[] count, int[] quantity, int index) {
        if (index == -1) return true;

        for (int i = 0; i < count.length; ++i) {
            if (count[i] >= quantity[index]) {
                count[i] -= quantity[index];
                if (dfs(count, quantity, index - 1))
                    return true;
                count[i] += quantity[index];
            }
        }
        return false;
    }


    public static void main(String[] args) {
        lc1655 test = new lc1655();
        System.out.println(test.canDistribute2(new int[]{1, 1, 2, 3}, new int[]{2, 2}));
    }

    public boolean canDistribute2(int[] nums, int[] quantity) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int m = map.size();
        int n = quantity.length;
        int index = 0;
        int[] count = new int[m];
        for (Integer value : map.values()) count[index++] = value;

        boolean[][] dp = new boolean[m][1 << n];
        for (int i = 0; i < m; ++i) dp[i][0] = true;
        for (int i = 0; i < m; ++i) {
            for (int state = 1; state < (1 << n); ++state) {
                if (i > 0 && dp[i - 1][state]) {
                    dp[i][state] = true;
                    continue;
                }
                for (int subset = state; subset > 0; subset = (subset - 1) & state) {
                    if (i > 0 && !dp[i - 1][state - subset]) continue;
                    if (i == 0 && state != subset) continue;

                    int sum = 0;
                    for (int k = 0; k < n; ++k) {
                        if (((subset >> k) & 1) > 0) sum += quantity[k];
                    }
                    if (sum <= count[i]) {
                        dp[i][state] = true;
                        break;
                    }
                }
            }
        }
        return dp[m - 1][(1 << n) - 1];
    }
}
