import java.util.LinkedList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/6/22
 */
public class lc513 {
    public int findBottomLeftValue(TreeNode root) {
        List<TreeNode> q = new LinkedList<>();
        q.add(root);
        int val = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            val = q.get(0).val;
            for (int i = 0; i < size; ++i) {
                TreeNode now = q.remove(0);
                if (now.left != null) q.add(now.left);
                if (now.right != null) q.add(now.right);
            }
        }

        return val;
    }
}
