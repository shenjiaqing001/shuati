package WeeklyContest265;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/30
 */
public class lc2058 {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int max = -1;
        int min = Integer.MAX_VALUE / 2;
        int count = -1;
        int maxCount = 0;
        int lastNum = head.val;
        head = head.next;
        while (head.next != null) {
            if (head.val < lastNum && head.val < head.next.val) {
                if (count != -1) {
                    max = Math.max(max, maxCount);
                    min = Math.min(min, count);
                }
                count = 0;
            } else if (head.val > lastNum && head.val > head.next.val) {
                if (count != -1) {
                    max = Math.max(max, maxCount);
                    min = Math.min(min, count);
                }
                count = 0;
            }
            if (count != -1) {
                count++;
                maxCount++;
            }
            lastNum = head.val;
            head = head.next;
        }
        if (max == -1) return new int[]{-1, -1};
        return new int[]{min, max};
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
