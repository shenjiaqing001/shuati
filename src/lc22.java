import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/6/17
 */
public class lc22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(res, "", n, n);

        return res;
    }

    public void dfs(List<String> res, String str, int left, int right) {
        if (right == 0) {
            res.add(str);
            return;
        }
        if (left > 0) {
            dfs(res, str + "(", left - 1, right);
        }

        if (right > left) {
            dfs(res, str + ")", left, right - 1);
        }
    }
}
