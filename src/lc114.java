import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/28/20
 */
public class lc114 {
    public void flatten(TreeNode root) {
        TreeNode last = root;
        while(root != null){
            if (root.left == null)
                root = root.right;
            else {
                last = root.left;
                while(last.right != null)
                    last = last.right;
                last.right = root.right;
                root.right = root.left;
                root.left = null;
            }
        }
    }


}
