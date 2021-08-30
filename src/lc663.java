import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/12/23
 */
public class lc663 {
    public boolean checkEqualTree(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int sum = getsum(root, map);
        if (sum == 0) return map.getOrDefault(sum, 0) > 1;
        return sum % 2 == 0 && map.containsKey(sum / 2);
    }

    public int getsum(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) return 0;
        int cur = root.val + getsum(root.left, map) + getsum(root.right, map);
        map.put(cur, map.getOrDefault(cur, 0) + 1);
        return cur;
    }
}
