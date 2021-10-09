/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/9
 */
public class lc979 {


    int res = 0;

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return res;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);
        res += Math.abs(left);
        res += Math.abs(right);

        return left + right + root.val - 1;
    }


}
