/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/27/20
 */
public class lc109 {
    ListNode now = null;

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        now = head;
        ListNode tmp = head;
        int count = 0;
        while (tmp != null) {
            count++;
            tmp = tmp.next;
        }

        return makeTreeNode(0, count - 1);
    }

    public TreeNode makeTreeNode(int low, int high) {
        if (low > high) return null;
        if (low == high) {
            TreeNode node = new TreeNode(now.val);
            now = now.next;
            return node;
        }

        int mid = (low + high) / 2;
        TreeNode left = makeTreeNode(low, mid - 1);
        TreeNode node = new TreeNode(now.val);
        now = now.next;
        TreeNode right = makeTreeNode(mid + 1, high);
        node.left = left;
        node.right = right;
        return node;
    }
}
