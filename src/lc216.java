import java.util.LinkedList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/9/20
 */
public class lc216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new LinkedList<>();
        dfs(res, new LinkedList<>(), 0, 0, k, n);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> now, int num, int sum, int k, int n) {
        if (sum == n && now.size() == k) {
            res.add(new LinkedList<>(now));
            return;
        }

        for (int i = num + 1; i <= 9; ++i) {
            now.add(i);
            dfs(res, now, i, sum + i, k, n);
            now.remove(now.size() - 1);
        }
    }
}
