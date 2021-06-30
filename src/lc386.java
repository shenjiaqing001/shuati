import java.util.LinkedList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/6/30
 */
public class lc386 {

    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new LinkedList<>();
        for (int i = 1; i <= 9; ++i) {
            if (i <= n)
                dfs(res, n, i);
        }
        return res;
    }

    public void dfs(List<Integer> res, int n, int num) {
        res.add(num);
        for (int i = 0; i < 10; ++i) {
            int next = num * 10 + i;
            if (next <= n) dfs(res, n, next);
        }
    }

}
