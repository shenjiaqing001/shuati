import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/9/30
 */
public class lc725 {
    public ListNode[] splitListToParts(ListNode head, int k) {
        List<ListNode> list = new ArrayList<>();
        ListNode tmp = head;
        int count = 0;
        while (tmp != null) {
            count++;
            tmp = tmp.next;
        }
        int[] nums = new int[k];
        for (int i = 0; i < k; ++i) {
            nums[i] = count / k;
        }
        for (int i = 0; i < count % k; ++i) nums[i]++;
        ListNode last = null;
        for (int i = 0; i < k; ++i) {
            if (head == null) list.add(null);
            else {
                list.add(head);
                last = head;
                while (nums[i] > 0) {
                    nums[i]--;
                    last = head;
                    head = head.next;
                }
            }
            if (last != null)
                last.next = null;
        }
        return list.toArray(new ListNode[0]);
    }
}
