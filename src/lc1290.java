/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/11/2
 */
public class lc1290 {
    public int getDecimalValue(ListNode head) {
        int res = 0;
        while (head != null) {
            res = res * 2 + head.val;
            head = head.next;
        }
        return res;
    }
}
