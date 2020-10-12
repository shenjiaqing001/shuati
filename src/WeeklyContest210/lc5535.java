package WeeklyContest210;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/11
 */
public class lc5535 {
    public int maxDepth(String s) {
        int res = 0;
        int max = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') res++;
            if (c == ')') res--;
            max = Math.max(max, res);
        }
        return max;
    }
}
