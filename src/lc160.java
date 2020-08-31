/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/14/20
 */


public class lc160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode a = headA;
        ListNode b = headB;
        int countA = 0;
        int countB = 0;

        while (a.next != null) {
            a = a.next;
            countA++;
        }
        while (b.next != null) {
            b = b.next;
            countB++;
        }
        if (a != b) return null;

        if (countA > countB) {
            int go = countA - countB;
            while (go-- > 0) headA = headA.next;
        } else {
            int go = countB - countA;
            while (go-- > 0) headB = headB.next;
        }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }
}
