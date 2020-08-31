/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/28/20
 */
public class lc1120 {
    public double maximumAverageSubtree(TreeNode root) {
        if (root == null) return 0;
        double max = Math.max(maximumAverageSubtree(root.left), maximumAverageSubtree(root.right));

        int[] left = sumSubTree(root.left);
        int[] right = sumSubTree(root.right);
        max = Math.max(max,
                (double) (left[1] + right[1] + root.val) / (double) (1 + left[0] + right[0]));
        return max;
    }

    // 1: sum, 0: count
    public int[] sumSubTree(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        int[] left = sumSubTree(root.left);
        int[] right = sumSubTree(root.right);
        return new int[]{left[0] + right[0] + 1, left[1] + right[1] + root.val};
    }


    public static void main(String[] args) {
        System.out.println((double) 5 / (double) 2);
    }
}
