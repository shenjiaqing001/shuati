/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/30
 */
public class lc549 {

    int max = 1;

    public int longestConsecutive(TreeNode root) {
        dfs(root);
        return max;
    }

    public int[] dfs(TreeNode root) {
        if (root == null) return new int[]{0, 0};

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int[] res = new int[]{1,1};
        // 0 升 1 降
        if (root.left != null) {
            if (root.val == root.left.val + 1) {
                res[0] = Math.max(res[0], left[0] + 1);
            } else {
                left[0] = 0;
            }
            if (root.val == root.left.val - 1) {
                res[1] = Math.max(res[1], left[1] + 1);
            } else {
                left[1] = 0;
            }
        }


        if (root.right != null) {
            if (root.val == root.right.val + 1) {
                res[0] = Math.max(res[0], right[0] + 1);
            } else {
                right[0] = 0;
            }
            if (root.val == root.right.val - 1) {
                res[1] = Math.max(res[1], right[1] + 1);
            } else {
                right[1] = 0;
            }
        }
        max = Math.max(max, left[0] + right[1] + 1);
        max = Math.max(max, left[1] + right[0] + 1);

        return res;
    }
}
