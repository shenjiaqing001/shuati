/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/27/20
 */
public class lc108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return makeTreeNode(nums, 0, nums.length - 1);
    }

    public TreeNode makeTreeNode(int[] nums, int low, int high) {
        if (low > high) return null;
        if (low == high) return new TreeNode(nums[low]);

        int mid = (low + high) / 2;
        TreeNode now = new TreeNode(nums[mid]);
        now.left = makeTreeNode(nums, low, mid - 1);
        now.right = makeTreeNode(nums, mid + 1, high);
        return now;
    }
}
