import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/28/20
 */
public class lc113 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        findPath(res, new ArrayList<>(), root, sum);
        return res;
    }

    public void findPath(List<List<Integer>> res, List<Integer> tmp,
                         TreeNode root, int sum) {
        if (root.left == null && root.right == null && root.val == sum) {
            tmp.add(root.val);
            res.add(new ArrayList<>(tmp));
            tmp.remove(tmp.size() - 1);
            return;
        }

        tmp.add(root.val);
        if (root.left != null) {
            findPath(res, tmp, root.left, sum - root.val);
        }
        if (root.right != null) {
            findPath(res, tmp, root.right, sum - root.val);
        }
        tmp.remove(tmp.size() - 1);
    }
}
