import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/11/10
 */
public class lc508 {
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        dfs(map, root);
        int max = 0;
        for (Integer key : map.keySet()) {
            max = Math.max(max, map.get(key));
        }

        List<Integer> list = new ArrayList<>();
        for (Integer key : map.keySet()) {
            if (map.get(key) == max) list.add(key);
        }

        int[] result = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }

    public int dfs(Map<Integer, Integer> map, TreeNode root) {
        if (root == null) return 0;

        int left = dfs(map, root.left);
        int right = dfs(map, root.right);
        int sum = left + right + root.val;
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        return sum;
    }

}
