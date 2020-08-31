import com.sun.source.tree.Tree;
import javafx.util.Pair;

import javax.swing.*;
import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/21/20
 */
public class lc314 {


    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        if (root == null) return res;

        Queue<Pair<Integer, TreeNode>> q = new LinkedList<>();
        q.add(new Pair<>(0, root));
        while (!q.isEmpty()) {
            Pair<Integer, TreeNode> now = q.poll();
            if (!map.containsKey(now.getKey())) {
                map.put(now.getKey(), new ArrayList<>());
                if (now.getKey() >= 0) res.add(map.get(now.getKey()));
                else res.add(0, map.get(now.getKey()));
            }
            map.get(now.getKey()).add(now.getValue().val);
            if (now.getValue().left != null) {
                q.add(new Pair<>(now.getKey() - 1, now.getValue().left));
            }
            if (now.getValue().right != null) {
                q.add(new Pair<>(now.getKey() + 1, now.getValue().right));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Map<List<Integer>, Integer> map = new HashMap<>();
        List<Integer> test = new LinkedList<>();
        test.add(5);
        System.out.println(test.hashCode());

        map.put(test, 5);

        test.add(7);

        System.out.println(test.hashCode());
        System.out.println(map.get(test));
    }
}
