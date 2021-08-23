import java.util.HashSet;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/8/23
 */
public class lc653 {
    Set<Integer> set = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        return dfs(root, k);
    }

    public boolean dfs(TreeNode root, int k) {
        if (root == null) return false;
        if (set.contains(k - root.val)) return true;
        set.add(root.val);
        return dfs(root.left, k) || dfs(root.right, k);
    }

}
