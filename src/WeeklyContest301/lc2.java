package WeeklyContest301;

import java.util.TreeSet;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/9/22
 */
public class lc2 {
    class SmallestInfiniteSet {
        TreeSet<Integer> set = new TreeSet<>();

        public SmallestInfiniteSet() {
            for (int i = 1; i <= 1005; ++i) {
                set.add(i);
            }
        }

        public int popSmallest() {
            return set.pollFirst();
        }

        public void addBack(int num) {
            set.add(num);
        }
    }
}
