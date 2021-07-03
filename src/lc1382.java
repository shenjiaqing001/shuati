import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/2
 */
public class lc1382 {
    List<Integer> list = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        BSTtoList(root);
        return listToBST(0, list.size() - 1);
    }

    public void BSTtoList(TreeNode root) {
        if (root == null) return;
        BSTtoList(root.left);
        list.add(root.val);
        BSTtoList(root.right);
    }

    public TreeNode listToBST(int left, int right) {
        if (left > right) return null;
        if (left == right) return new TreeNode(list.get(left));

        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = listToBST(left, mid - 1);
        root.right = listToBST(mid + 1, right);

        return root;
    }
}
