import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/6
 */
public class lc1110 {
    public TreeNode dfs(List<TreeNode> res, Set<Integer> set, TreeNode root, boolean flag) {
        if (root == null) return null;
        if (flag && !set.contains(root.val)) {
            res.add(root);
            root.left = dfs(res, set, root.left, false);
            root.right = dfs(res, set, root.right, false);
        } else {
            if (set.contains(root.val)) {
                root.left = dfs(res, set, root.left, true);
                root.right = dfs(res, set, root.right, true);
            } else {
                root.left = dfs(res, set, root.left, false);
                root.right = dfs(res, set, root.right, false);
            }
        }
        if (set.contains(root.val)) return null;
        else return root;
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int num : to_delete) set.add(num);
        dfs(res, set, root, true);
        return res;
    }
}
