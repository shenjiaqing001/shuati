import java.util.HashSet;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/3
 */
public class lc1650 {
    public Node lowestCommonAncestor(Node p, Node q) {
        HashSet<Integer> set = new HashSet<>();

        while (p != null) {
            set.add(p.val);
            p = p.parent;
        }

        while (!set.contains(q.val)) {
            q = q.parent;
        }

        return q;
    }
}
