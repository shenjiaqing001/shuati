import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/3
 */
public class lc622 {
    class MyCircularQueue {
        Deque<Integer> q = new LinkedList<>();
        int size = 0;

        public MyCircularQueue(int k) {

            this.size = k;
        }

        public boolean enQueue(int value) {
            if (q.size() == size) return false;
            return q.offerLast(value);
        }

        public boolean deQueue() {
            if (q.isEmpty()) return false;
            q.pollFirst();
            return true;
        }

        public int Front() {
            if (q.isEmpty()) return -1;
            return q.peekFirst();
        }

        public int Rear() {
            if (q.isEmpty()) return -1;
            return q.peekLast();
        }

        public boolean isEmpty() {
            return q.isEmpty();
        }

        public boolean isFull() {
            if (q.size() == size) return true;
            else return false;
        }
    }

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
}
