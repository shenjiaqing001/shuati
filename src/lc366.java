import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/22
 */
public class lc366 {
    public List<List<Integer>> findLeaves(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        dfs(map, root);
        List<List<Integer>> res = new ArrayList<>();
        int i = 1;
        while (map.containsKey(i)) {
            res.add(map.get(i));
            i++;
        }
        return res;
    }

    public int dfs(Map<Integer, List<Integer>> map, TreeNode root) {
        if (root == null) return 0;
        int depth = Math.max(dfs(map, root.left), dfs(map, root.right)) + 1;
        map.putIfAbsent(depth, new ArrayList<>());
        map.get(depth).add(root.val);
        return depth;
    }
}
