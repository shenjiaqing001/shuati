/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/23
 */
public class lc1448 {
    public int goodNodes(TreeNode root) {
        return goodNodes(root, -10000);
    }

    public int goodNodes(TreeNode root, int max) {
        if (root == null) return 0;
        int res = root.val >= max ? 1 : 0;
        res += goodNodes(root.left, Math.max(max, root.val));
        res += goodNodes(root.right, Math.max(max, root.val));
        return res;
    }
}
