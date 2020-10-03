import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/3
 */
public class lc39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        dfs(res, new LinkedList<>(), candidates, 0, target);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> list, int[] candidates, int index,
                    int target) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < candidates.length; ++i) {
            if (candidates[i] <= target) {
                list.add(candidates[i]);
                dfs(res, list, candidates, i, target - candidates[i]);
                list.remove(list.size() - 1);
            }
        }

    }
}
