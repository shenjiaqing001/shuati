import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/6/22
 */
public class lc515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        List<TreeNode> q = new LinkedList<>();

        q.add(root);
        while (!q.isEmpty()) {
            int max = Integer.MIN_VALUE;
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                TreeNode now = q.remove(0);
                max = Math.max(now.val, max);
                if (now.left != null) q.add(now.left);
                if (now.right != null) q.add(now.right);
            }
            res.add(max);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(2147483647 > -2147483648);
    }
}
