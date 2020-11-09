/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/11/10
 */
public class lc1026 {
    int result = 0;

    public int maxAncestorDiff(TreeNode root) {
        dfs(root, root.val, root.val);
        return result;
    }

    private void dfs(TreeNode node, int curMax, int curMin) {
        if (node == null)
            return;
        result = Math.max(result,
                Math.max(Math.abs(curMax - node.val), Math.abs(curMin - node.val)));
        curMax = Math.max(curMax, node.val);
        curMin = Math.min(curMin, node.val);
        dfs(node.left, curMax, curMin);
        dfs(node.right, curMax, curMin);
    }
}
