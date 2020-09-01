import java.util.LinkedList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/1/20
 */
public class lc428 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }


    class Codec {
        // Encodes a tree to a single string.
        public String serialize(Node root) {
            return encode(root);
        }

        public String encode(Node root) {
            if (root == null) return "";
            if (root.children == null)
                return "[" + root.val + "]";
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(root.val);

            for (Node n : root.children) {
                sb.append(encode(n));
            }
            sb.append("]");
            return sb.toString();
        }


        // Decodes your encoded data to tree.
        public Node deserialize(String data) {
            int[] pos = new int[]{0};
            Node test = deserialize(data.toCharArray(), pos);
            return test;
        }

        public Node deserialize(char[] data, int[] pos) {
            if (data.length == 0) return null;
            pos[0]++;
            Node now = new Node(detectNum(data, pos));
            while (pos[0] < data.length && data[pos[0]] != ']') {
                Node child = deserialize(data, pos);
                if (now.children == null)
                    now.children = new LinkedList<>();
                now.children.add(child);
            }
            pos[0]++;
            return now;
        }

        public int detectNum(char[] data, int[] pos) {
            int a = 0;
            while (data[pos[0]] - '0' >= 0 && data[pos[0]] - '0' <= 9) {
                a = 10 * a + (data[pos[0]] - '0');
                pos[0]++;
            }
            return a;
        }
    }

    public void test() {
        Codec c = new Codec();
        System.out.println(c.serialize(c.deserialize("[1[3[5][6]][2][4]]")));
    }


    public static void main(String[] args) {
        lc428 t = new lc428();
        t.test();

    }
}
