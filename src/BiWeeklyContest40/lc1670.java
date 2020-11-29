package BiWeeklyContest40;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/11/29
 */
public class lc1670 {
    class FrontMiddleBackQueue {
        LinkedList<Integer> q;

        public FrontMiddleBackQueue() {
            q = new LinkedList<>();
        }

        public void pushFront(int val) {
            q.addFirst(val);
        }

        public void pushMiddle(int val) {
            q.add(q.size() / 2, val);
        }

        public void pushBack(int val) {
            q.addLast(val);
        }

        public int popFront() {
            return q.isEmpty() ? -1 : q.removeFirst();
        }

        public int popMiddle() {
            return q.isEmpty() ? -1 : q.remove((q.size() - 1) / 2);
        }

        public int popBack() {
            return q.isEmpty() ? -1 : q.removeLast();
        }
    }

}
