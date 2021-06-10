/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/4/21
 */
public class lc1008 {
    public void addNode(TreeNode root, int num) {
        if (root.val > num) {
            if (root.left != null)
                addNode(root.left, num);
            else
                root.left = new TreeNode(num);
        } else if (root.val < num) {
            if (root.right != null)
                addNode(root.right, num);
            else root.right = new TreeNode(num);
        }
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 1; i < preorder.length; ++i) {
            addNode(root, preorder[i]);
        }
        return root;
    }
}
