import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/23
 */
public class lc894 {
    Map<Integer, List<TreeNode>> map = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int n) {
        if (map.containsKey(n)) return map.get(n);
        List<TreeNode> res = new ArrayList<>();
        if (n % 2 == 0) return res;
        if (n == 1) {
            res.add(new TreeNode(0));
            map.put(1, res);
            return res;
        }
        for (int i = 1; i <= n - 1; i += 2) {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(n - 1 - i);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        map.put(n, res);
        return res;
    }

}
