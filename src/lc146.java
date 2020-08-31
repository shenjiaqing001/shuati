import java.nio.charset.IllegalCharsetNameException;
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

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    class LRUCache {
        Map<Integer, Node> map = new HashMap<>();
        Node leftHead;
        Node rightHead;
        int size;
        int capacity = 0;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.leftHead = null;
            this.rightHead = null;
            this.size = 0;
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                Node now = map.get(key);
                if (leftHead != now) {
                    if (now.right == null) {
                        now.left.right = null;
                        now.right = leftHead;
                        rightHead = now.left;
                        now.left = null;
                        leftHead.left = now;
                        leftHead = now;
                    } else {
                        leftHead.left = now;
                        now.right.left = now.left;
                        now.left.right = now.right;
                        now.left = null;
                        now.right = leftHead;
                        leftHead = now;
                    }
                }
                return now.val;
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            if (size == 0) {
                Node now = new Node(key, value);
                rightHead = now;
                leftHead = now;
                map.put(key, now);
                size++;
            }
            else if (capacity == 1){
                map.remove(leftHead.key);
                Node now = new Node(key,value);
                leftHead = now;
                rightHead = now;
                map.put(key,now);
            }
            else {
                if (map.containsKey(key)) {
                    Node now = map.get(key);
                    now.val = value;
                    if (leftHead != now) {
                        if (now.right == null) {
                            now.left.right = null;
                            now.right = leftHead;
                            rightHead = now.left;
                            now.left = null;
                            leftHead.left = now;
                            leftHead = now;
                        } else {
                            leftHead.left = now;
                            now.right.left = now.left;
                            now.left.right = now.right;
                            now.left = null;
                            now.right = leftHead;
                            leftHead = now;
                        }
                    }
                } else {
                    if (size < capacity) {
                        size++;
                    } else {
                        map.remove(rightHead.key);
                        rightHead.left.right = null;
                        rightHead = rightHead.left;
                    }

                    Node newNode = new Node(key, value);
                    newNode.right = leftHead;
                    leftHead.left = newNode;
                    leftHead = newNode;
                    map.put(key, newNode);
                }
            }
        }
    }
}
