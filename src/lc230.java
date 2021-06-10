/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/1/21
 */
public class lc230 {
    public int kthSmallest(TreeNode root, int k) {
        int left = count(root.left);
        if (left >= k) return kthSmallest(root.left, k);
        if (left + 1 == k) return root.val;
        else return kthSmallest(root.right, k - left - 1);
    }

    public int count(TreeNode root) {
        if (root == null) return 0;
        return count(root.left) + count(root.right) + 1;
    }
}
