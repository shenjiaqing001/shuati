import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2/27/22
 */
public class lc1172 {
    class DinnerPlates {

        List<Deque<Integer>> lists = new ArrayList<>();
        TreeSet<Integer> notFull = new TreeSet<>();
        TreeSet<Integer> notEmpty = new TreeSet<>();
        int capacity;
        int size = 0;

        public DinnerPlates(int capacity) {
            this.capacity = capacity;
        }

        public void push(int val) {
            if (notFull.isEmpty()) {
                lists.add(new ArrayDeque<>());
                notFull.add(size++);
            }
            int first = notFull.first();
            lists.get(first).addLast(val);
            if (lists.get(first).size() == capacity) {
                notFull.remove(first);
            }
            notEmpty.add(first);
        }

        public int pop() {
            if (notEmpty.isEmpty()) return -1;
            int last = notEmpty.last();
            int res = lists.get(last).pollLast();
            if (lists.get(last).size() == 0) {
                notEmpty.remove(last);
            }
            notFull.add(last);
            return res;
        }

        public int popAtStack(int index) {
            if(!notEmpty.contains(index)) return -1;
            int res = lists.get(index).pollLast();
            if (lists.get(index).size() == 0) {
                notEmpty.remove(index);
            }
            notFull.add(index);
            return res;
        }
    }

/**
 * Your DinnerPlates object will be instantiated and called as such:
 * DinnerPlates obj = new DinnerPlates(capacity);
 * obj.push(val);
 * int param_2 = obj.pop();
 * int param_3 = obj.popAtStack(index);
 */
}
