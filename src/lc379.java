import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/6/27
 */
public class lc379 {
    class PhoneDirectory {

        boolean[] isAssigned;
        Queue<Integer> q = new LinkedList<>();

        /**
         * Initialize your data structure here
         *
         * @param maxNumbers - The maximum numbers that can be stored in the phone directory.
         */
        public PhoneDirectory(int maxNumbers) {
            isAssigned = new boolean[maxNumbers];
            for (int i = 0; i < maxNumbers; ++i) {
                q.add(i);
            }
        }

        /**
         * Provide a number which is not assigned to anyone.
         *
         * @return - Return an available number. Return -1 if none is available.
         */
        public int get() {
            if (q.isEmpty()) return -1;
            int slot = q.poll();
            isAssigned[slot] = true;
            return slot;
        }

        /**
         * Check if a number is available or not.
         */
        public boolean check(int number) {
            return isAssigned[number];
        }

        /**
         * Recycle or release a number.
         */
        public void release(int number) {
            if (!isAssigned[number]) return;

            isAssigned[number] = false;
            q.add(number);
        }
    }
}
