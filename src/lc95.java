import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/25/20
 */
public class lc95 {

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return Collections.emptyList();
        return recursive(1, n);
    }

    public List<TreeNode> recursive(int start, int end) {
        List<TreeNode> res = new ArrayList<>();

        if (start > end) {
            res.add(null);
            return res;
        }
        if (start == end) {
            res.add(new TreeNode(start));
            return res;
        }

        for (int i = start; i <= end; ++i) {
            List<TreeNode> leftList = recursive(start, i - 1);
            List<TreeNode> rightList = recursive(i + 1, end);

            for (TreeNode left : leftList) {
                for (TreeNode right : rightList) {
                    TreeNode tmp = new TreeNode(i);
                    tmp.left = left;
                    tmp.right = right;
                    res.add(tmp);
                }
            }
        }
        return res;
    }
}
