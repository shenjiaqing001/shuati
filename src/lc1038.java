

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/6/21
 */
public class lc1038 {
    public TreeNode bstToGst(TreeNode root) {
        dfs(root, 0);
        return root;
    }

    public int dfs(TreeNode root, int num) {
        if (root == null) return num;
        int right = dfs(root.right, num);
        root.val = right + root.val;
        int left = dfs(root.left, root.val);
        return left;
    }

}
