import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/10/20
 */
public class lc146 {
    class Node {
        int val;
        int key;
        Node left;
        Node right;

        Node() {

        }

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    class LRUCache {
        Map<Integer, Node> map = new HashMap<>();
        Node leftHead = new Node(-1, -1);
        Node rightHead = new Node(-2, -2);
        int size = 0;
        int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            leftHead.right = rightHead;
            rightHead.left = leftHead;
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                Node now = map.get(key);
                Node l = now.left;
                Node r = now.right;
                l.right = r;
                r.left = l;
                Node tmp = leftHead.right;
                leftHead.right = now;
                now.left = leftHead;
                tmp.left = now;
                now.right = tmp;
                return now.val;
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                Node now = map.get(key);
                Node l = now.left;
                Node r = now.right;
                l.right = r;
                r.left = l;
                Node tmp = leftHead.right;
                leftHead.right = now;
                now.left = leftHead;
                tmp.left = now;
                now.right = tmp;
                now.val = value;
            } else {
                if (size < capacity) {
                    size++;
                } else {
                    Node n = rightHead.left;
                    Node tmp = rightHead.left.left;
                    tmp.right = rightHead;
                    rightHead.left = tmp;
                    map.remove(n.key);
                }
                Node newNode = new Node(key, value);
                map.put(key, newNode);
                Node tmp = leftHead.right;
                newNode.left = leftHead;
                leftHead.right = newNode;
                newNode.right = tmp;
                tmp.left = newNode;
            }
        }
    }
}
