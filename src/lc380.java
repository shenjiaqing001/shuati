import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/31/20
 */
public class lc380 {
    class RandomizedSet {

        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        Random random = new Random();

        /**
         * Initialize your data structure here.
         */
        public RandomizedSet() {

        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain the specified element.
         */
        public boolean insert(int val) {
            if (map.containsKey(val))
                return false;
            else {
                list.add(val);
                map.put(val, list.size() - 1);
                return true;
            }
        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified element.
         */
        public boolean remove(int val) {
            if (!map.containsKey(val))
                return false;
            else {
                int pos = map.get(val);
                int num = list.get(list.size() - 1);
                map.put(num, pos);
                map.remove(val);
                list.set(pos, num);
                list.remove(list.size() - 1);
                return true;
            }
        }

        /**
         * Get a random element from the set.
         */
        public int getRandom() {
            int index = random.nextInt(list.size());
            return list.get(index);
        }
    }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
}
