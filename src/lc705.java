/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/23
 */
public class lc705 {
    class MyHashSet {

        boolean[] hashSet = new boolean[1_000_000 + 1];

        /**
         * Initialize your data structure here.
         */
        public MyHashSet() {

        }

        public void add(int key) {
            hashSet[key] = true;
        }

        public void remove(int key) {
            hashSet[key] = false;
        }

        /**
         * Returns true if this set contains the specified element
         */
        public boolean contains(int key) {
            return hashSet[key];
        }
    }

}
