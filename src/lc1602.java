import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/12/23
 */
public class lc1602 {
    public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (true) {
            int num = q.size();
            boolean flag = false;
            for (int i = 0; i < num; ++i) {
                TreeNode now = q.poll();
                if (flag == true) return now;
                if (now.val == u.val) {
                    flag = true;
                }
                if (now.left != null)
                    q.add(now.left);
                if (now.right != null)
                    q.add(now.right);
            }
            if (flag == true) return null;
        }
    }
}
