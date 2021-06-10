import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/1/30
 */
public class lc987 {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>();
        dfs(map, root, 0, 0);
        List<List<Integer>> res = new ArrayList<>();
        for (TreeMap<Integer, List<Integer>> tmp : map.values()) {
            List<Integer> list = new ArrayList<>();
            for (List<Integer> tmp2 : tmp.values()) {
                tmp2.sort(Comparator.comparingInt(o -> o));
                for (Integer num : tmp2) {
                    list.add(num);
                }
            }
            res.add(list);
        }
        return res;
    }

    public void dfs(TreeMap<Integer, TreeMap<Integer, List<Integer>>> map, TreeNode root, int x,
                    int y) {
        if (root == null) return;
        map.putIfAbsent(x, new TreeMap<>());
        map.get(x).putIfAbsent(y, new ArrayList<>());
        map.get(x).get(y).add(root.val);
        dfs(map, root.left, x - 1, y + 1);
        dfs(map, root.right, x + 1, y + 1);
    }
}
