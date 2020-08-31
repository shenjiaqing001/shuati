import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/27/20
 */
public class lc104 {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
