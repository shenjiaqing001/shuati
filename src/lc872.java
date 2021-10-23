import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/23
 */
public class lc872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        dfs(list1, root1);
        dfs(list2, root2);
        if (list1.size() != list2.size()) return false;
        for (int i = 0; i < list1.size(); ++i) {
            if (list1.get(i) != list2.get(i)) return false;
        }
        return true;
    }

    public void dfs(List<Integer> list, TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            list.add(root.val);
            return;
        }
        dfs(list, root.left);
        dfs(list, root.right);
    }
}
