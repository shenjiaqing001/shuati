import java.util.LinkedList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/19/20
 */
public class lc199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;

        List<TreeNode> tmp = new LinkedList<>();
        tmp.add(root);
        while (tmp.size() > 0) {
            List<TreeNode> newTmp = new LinkedList<>();
            res.add(tmp.get(tmp.size() - 1).val);
            for (TreeNode t : tmp) {
                if (t.left != null) newTmp.add(t.left);
                if (t.right != null) newTmp.add(t.right);
            }
            tmp = newTmp;
        }
        return res;
    }
}
