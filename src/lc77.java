import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/22/20
 */
public class lc77 {
    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> res = new ArrayList<>();

        dfs(res, new ArrayList<>(), n, k, 1);
        return res;


    }

    public void dfs(List<List<Integer>> res, ArrayList<Integer> now, int n,
                    int k, int start) {
        if (now.size() == k)
            res.add(new ArrayList<>(now));
        else {
            for (int i = start; i <= n; ++i) {
                now.add(i);
                dfs(res, now, n, k, i + 1);
                now.remove(new Integer(i));
            }
        }
    }
}
