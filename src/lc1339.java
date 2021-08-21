/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/8/20
 */
public class lc1339 {
    long max = 0;
    long total = 0;

    public int maxProduct(TreeNode root) {
        total = sum(root);
        dfs(root);
        return (int) (max % 1_000_000_007);
    }

    public long dfs(TreeNode root) {
        if (root == null) return 0;
        long sum = dfs(root.left) + dfs(root.right) + root.val;
        if (sum * (total - sum) > max)
            max = sum * (total - sum);
        return sum;
    }

    public int sum(TreeNode root) {
        if (root == null) return 0;
        return sum(root.left) + sum(root.right) + root.val;
    }

}
