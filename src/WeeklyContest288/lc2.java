package WeeklyContest288;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 4/9/22
 */
public class lc2 {
    public String minimizeResult(String expression) {
        String left = expression.split("\\+")[0];
        String right = expression.split("\\+")[1];
        int min = Integer.MAX_VALUE;

        String res = "";
        for (int i = 0; i < left.length(); ++i) {
            for (int j = 1; j <= right.length(); ++j) {
                int ll;
                if (i == 0) ll = 1;
                else {
                    ll = Integer.parseInt(left.substring(0, i));
                }
                int lr = Integer.parseInt(left.substring(i));
                int rl = Integer.parseInt(right.substring(0, j));
                int rr;
                if (j == right.length()) {
                    rr = 1;
                } else {
                    rr = Integer.parseInt(right.substring(j));
                }
                int total = ll * (lr + rl) * rr;
                if (total < min) {
                    min = total;
                    res = left.substring(0, i) + "(" + left.substring(i) + "+" +
                            right.substring(0, j) + ")" + right.substring(j);
                }
            }
        }
        return res;
    }
}
