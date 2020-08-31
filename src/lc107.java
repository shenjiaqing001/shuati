import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/27/20
 */
public class lc107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        List<TreeNode> last = new ArrayList<>();
        last.add(root);
        while (!last.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            List<TreeNode> tmp = new ArrayList<>();
            for (TreeNode node : last) {
                level.add(node.val);
                if (node.left != null) tmp.add(node.left);
                if (node.right != null) tmp.add(node.right);
            }
            res.add(0,level);
            last = tmp;
        }
        return res;
    }
}
