/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/8/20
 */
public class lc437 {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;

        return dfs(root, sum) + pathSum(root.left, sum) +
                pathSum(root.right, sum);
    }

    public int dfs(TreeNode node, int num) {
        if (node == null) return 0;

        return (node.val == num ? 1 : 0) + dfs(node.left, num - node.val) +
                dfs(node.right, num - node.val);
    }
}
