/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/16/20
 */
public class lc968 {
    public int minCameraCover(TreeNode root) {
        if (root == null) return 0;
        int[] res = minCamera(root);

        if(res[1] == -1) return res[0]+1;
        else return res[0];
    }

    public int[] minCamera(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        if (root.left == null && root.right == null) return new int[]{0, -1};
        int[] left = minCamera(root.left);
        int[] right = minCamera(root.right);
        int res = left[0] + right[0];
        if (left[1] == -1 || right[1] == -1) return new int[]{res + 1, 1};
        int max = Math.max(left[1] - 1, right[1] - 1);
        return new int[]{res, max};
    }
}
