/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/8/25
 */
public class lc333 {
    int max = 0;

    public int largestBSTSubtree(TreeNode root) {
        dfs(root);
        return max;
    }

    public int[] dfs(TreeNode root) {
        if (root == null) return new int[]{-1, -1, 0};

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int[] res = new int[]{root.val, root.val, 1};
        if (left[2] == -1 || right[2] == -1) return new int[]{-1, -1, -1};
        if (left[2] != 0) {
            if (left[1] >= root.val) return new int[]{-1, -1, -1};
            res[0] = left[0];
            res[2] += left[2];
        }
        if (right[2] != 0) {
            if (right[0] <= root.val) return new int[]{-1, -1, -1};
            res[1] = right[1];
            res[2] += right[2];
        }
        max = Math.max(max, res[2]);
        return res;
    }
}
