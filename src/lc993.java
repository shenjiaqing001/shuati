import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/11/2
 */
public class lc993 {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;
        Set<Integer> set = new HashSet<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            set.clear();
            while (size-- > 0) {
                TreeNode cur = q.poll();
                if (cur.left != null) {
                    q.add(cur.left);
                    set.add(cur.left.val);
                }
                if (cur.right != null) {
                    q.add(cur.right);
                    set.add(cur.right.val);
                }
                if (cur.left != null && cur.right != null &&
                        ((cur.left.val == x && cur.right.val == y) ||
                                (cur.left.val == y && cur.right.val == x))) {
                    return false;
                }
            }
            if (set.contains(x) && set.contains(y)) return true;
        }
        return false;
    }
}
