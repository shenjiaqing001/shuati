import java.util.LinkedList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/13/20
 */
public class lc257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new LinkedList<>();
        if (root == null) return res;
        dfs(root, res, String.valueOf(root.val));
        return res;
    }

    public void dfs(TreeNode node, List<String> res, String str) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            res.add(str);
            return;
        }

        if (node.left != null)
            dfs(node.left, res, str + "->" + node.left.val);
        if (node.right != null)
            dfs(node.right, res, str + "->" + node.right.val);

    }


}
