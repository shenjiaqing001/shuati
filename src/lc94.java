import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/25/20
 */
public class lc94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack  = new Stack<>();

        while (true){
            while(root != null){
                stack.add(root);
                root = root.left;
            }
            if(stack.isEmpty())
                break;

            TreeNode tmp = stack.pop();
            res.add(tmp.val);
            root = tmp.right;
        }
        return res;
    }
}
