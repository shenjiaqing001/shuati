package WeeklyContest205;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/6/20
 */
public class lc5509 {
    public int minCost(String s, int[] cost) {
        if (s == null || s.length() == 0) return 0;
        int res = 0;
        char[] c = s.toCharArray();
        char last = c[0];
        int lastIndex = 0;
        for (int i = 1; i < s.length(); ++i) {
            if (c[i] == last) {
                if (cost[lastIndex] < cost[i]) {
                    res += cost[lastIndex];
                    lastIndex = i;
                } else {
                    res += cost[i];
                }
            } else {
                last = c[i];
                lastIndex = i;
            }
        }
        return res;
    }
}
