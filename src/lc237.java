/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/11/20
 */
public class lc237 {
    public void deleteNode(ListNode node) {
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
    }
}
