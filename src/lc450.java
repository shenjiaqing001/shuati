/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/31/20
 */
public class lc450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;
        if (root.val == key)
            return delete(root);
        else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }

        return root;
    }

    public TreeNode delete(TreeNode root) {
        if (root.left == null)
            return root.right;
        if (root.right == null)
            return root.left;

        if (root.left.right == null) {
            root.left.right = root.right;
            return root.left;
        }
        if (root.right.left == null) {
            root.right.left = root.left;
            return root.right;
        }


        TreeNode tmp = root.left;
        while (tmp.right.right != null) tmp = tmp.right;

        TreeNode newRoot = tmp.right;
        tmp.right = newRoot.left;
        newRoot.left = root.left;
        newRoot.right = root.right;
        return newRoot;
    }
}
