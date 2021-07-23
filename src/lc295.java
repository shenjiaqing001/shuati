import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/12/20
 */
public class lc295 {
    class MedianFinder {
        PriorityQueue<Integer> small = new PriorityQueue<>();
        PriorityQueue<Integer> large = new PriorityQueue<>(Collections.reverseOrder());

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {

        }

        public void addNum(int num) {
            large.add(num);
            small.add(large.poll());
            if (large.size() < small.size()) {
                large.offer(small.poll());
            }
        }

        public double findMedian() {
            if (large.size() != small.size())
                return large.peek();
            else
                return (large.peek() + small.peek()) / 2.0;
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
}
