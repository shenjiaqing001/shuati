import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/14/20
 */
public class lc652 {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();

        postOrder(root, res, map);
        return res;
    }

    public String postOrder(TreeNode root, List<TreeNode> res, Map<String, Integer> map) {
        if (root == null) return "#";
        String str = root.val + "," + postOrder(root.left, res, map) + "," +
                postOrder(root.right, res, map);
        if (map.containsKey(str) && map.get(str) == 1) res.add(root);
        map.put(str, map.getOrDefault(str, 0) + 1);
        return str;
    }
}
