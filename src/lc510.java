/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/15/20
 */
public class lc510 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }

    public Node inorderSuccessor(Node node) {
        if (node.right != null){
            node = node.right;
            while(node.left != null) node = node.left;
            return node;
        }
        if (node.parent == null) return null;
        if (node.parent.left == node) return node.parent;
        while (node.parent != null && node.parent.right == node) {
            node = node.parent;
        }
        if (node.parent == null) return null;
        else return node.parent;
    }
}
