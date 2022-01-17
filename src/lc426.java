/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/12/12
 */
public class lc426 {
    Node tmp = new Node();
    Node head = tmp;

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        dfs(root);
        tmp.right = head.right;
        head = head.right;
        head.left = tmp;
        return head;
    }

    public void dfs(Node root) {
        if (root == null) return;
        dfs(root.left);
        tmp.right = root;
        root.left = tmp;
        tmp = tmp.right;
        dfs(root.right);
    }

}
