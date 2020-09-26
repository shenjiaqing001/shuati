/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/9/26
 */
public class lc270 {
    int min = Integer.MAX_VALUE;
    double minD = Double.MAX_VALUE;

    public int closestValue(TreeNode root, double target) {
        dfs(root, target);
        return min;
    }

    public void dfs(TreeNode root, double target) {
        double minTmp = Math.abs(root.val - target);
        if (minTmp < minD) {
            min = root.val;
            minD = minTmp;
        }

        if (root.val > target) {
            if (root.left != null) dfs(root.left, target);
        } else if (root.val < target) {
            if (root.right != null) dfs(root.right, target);
        }
    }
}
