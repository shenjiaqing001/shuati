import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/11/22
 */
public class lc1612 {

    public void dfs(Map<Character, Integer> map, Node root) {
        if (root == null) return;
        if (root.val == '+') {
            dfs(map, root.left);
            dfs(map, root.right);
        } else {
            map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        }
    }

    public boolean checkEquivalence(Node root1, Node root2) {
        Map<Character, Integer> m1 = new HashMap<>();
        Map<Character, Integer> m2 = new HashMap<>();
        dfs(m1, root1);
        dfs(m2, root2);
        for (char i = 'a'; i <= 'z'; ++i) {
            if (m1.getOrDefault(i, 0) != m2.getOrDefault(i, 0)) return false;
        }
        return true;
    }

    class Node {
        char val;
        Node left;
        Node right;

        Node() {
            this.val = ' ';
        }

        Node(char val) {
            this.val = val;
        }

        Node(char val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
