import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/6/20
 */
public class lc133 {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        if (node.neighbors.size() == 0) {
            return new Node(node.val);
        }

        Map<Integer, Node> map = new HashMap<>();
        List<Node> q = new LinkedList<>();
        q.add(node);
        boolean[] flag = new boolean[105];
        while (q.size() >= 1) {
            Node tmp = q.remove(0);
            Node now;
            if(flag[tmp.val]) continue;
            if (map.containsKey(tmp.val)) {
                now = map.get(tmp.val);
            } else {
                now = new Node(tmp.val);
                map.put(tmp.val, now);
            }
            for (Node neighbor : tmp.neighbors) {
                if (map.containsKey(neighbor.val)) {
                    now.neighbors.add(map.get(neighbor.val));
                } else {
                    Node n = new Node(neighbor.val);
                    map.put(neighbor.val, n);
                    now.neighbors.add(n);
                }
                if (flag[neighbor.val] == false)
                    q.add(neighbor);
            }
            flag[tmp.val] = true;
        }

        return map.get(node.val);
    }
}
