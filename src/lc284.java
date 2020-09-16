import java.util.Iterator;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/17/20
 */
public class lc284 {
    class PeekingIterator implements Iterator<Integer> {
        Iterator<Integer> iterator;
        Integer next;

        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            this.iterator = iterator;
            if (this.iterator.hasNext()) {
                next = iterator.next();
            }

        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            return next;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            Integer tmp = next;
            if (iterator.hasNext()) {
                next = iterator.next();
            } else
                next = null;
            return tmp;
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }
    }
}
