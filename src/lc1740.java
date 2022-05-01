/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 12/23/21
 */
public class lc1740 {


    int res = 0;

    public int findDistance(TreeNode root, int p, int q) {
        root = LCA(root, p, q);
        System.out.println(root.val);
        distance(root, p, 0);
        distance(root, q, 0);

        return res;
    }

    public void distance(TreeNode root, int number, int level) {
        if (root == null) return;
        if (root.val == number) {
            res += level;
            return;
        }
        distance(root.left, number, level);
        distance(root.right, number, level);
    }

    public TreeNode LCA(TreeNode root, int p, int q) {
        if (root == null) return null;
        if (root.val == p || root.val == q) return root;
        TreeNode left = LCA(root.left, p, q);
        TreeNode right = LCA(root.right, p, q);
        return left != null && right != null ? root : left == null ? right : left;
    }
}
