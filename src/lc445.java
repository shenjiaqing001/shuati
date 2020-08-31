import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/31/20
 */
public class lc445 {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> num1 = new ArrayList<>();
        List<Integer> num2 = new ArrayList<>();

        while (l1 != null) {
            num1.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            num2.add(l2.val);
            l2 = l2.next;
        }

        ListNode begin = new ListNode();

        int i = num1.size() - 1, j = num2.size() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry == 1) {
            int n1 = i < 0 ? 0 : num1.get(i);
            int n2 = j < 0 ? 0 : num2.get(j);
            int now = (carry + n1 + n2) % 10;
            carry = (carry + n1 + n2) / 10;

            ListNode tmp = begin.next;
            begin.next = new ListNode(now);
            begin.next.next = tmp;
            i--;
            j--;
        }
        return begin.next;
    }

}
