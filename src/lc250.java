/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/14/20
 */
public class lc250 {
    int res = 0;

    public int countUnivalSubtrees(TreeNode root) {
        isUnival(root);
        return res;
    }

    public int isUnival(TreeNode root) {
        if (root == null) return 1001;
        if (root.left == null && root.right == null) {
            res += 1;
            return root.val;
        }
        int left = isUnival(root.left);
        int right = isUnival(root.right);

        if (left == -1001 || right == -1001) return -1001;
        if (left == 1001 && right == root.val) {
            res++;
            return root.val;
        }
        if (right == 1001 && left == root.val) {
            res++;
            return root.val;
        }
        if (right == root.val && left == root.val) {
            res++;
            return root.val;
        } else {
            return -1001;
        }
    }
}
