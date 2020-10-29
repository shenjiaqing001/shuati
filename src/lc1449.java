/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/29
 */
public class lc1449 {
    public String largestNumber(int[] cost, int target) {
        String[] dp = new String[target + 1];
        dfs(dp, cost, target);
        return dp[target];
    }

    public String dfs(String[] dp, int[] cost, int target) {
        if (target == 0) return "";
        if (dp[target] != null) return dp[target];
        String max = "0";
        for (int i = 0; i < 9; i++) {
            if (target >= cost[i]) {
                String curr = dfs(dp, cost, target - cost[i]);
                System.out.println(curr);
                if (curr.equals("0")) continue;
                curr = (i + 1) + curr;
                System.out.println(curr);
                if (max.length() > curr.length()) continue;
                if (max.equals("0") || curr.length() > max.length() ||
                        curr.length() == max.length() && max.compareTo(curr) < 0) max = curr;
            }
        }
        return dp[target] = max;
    }

}
