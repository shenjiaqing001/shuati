package BiWeeklyContest67;

import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 12/11/21
 */
public class lc2102 {

    class SORTracker {
        PriorityQueue<Object[]> pqLeft = new PriorityQueue<>(((o1, o2) -> {
            if ((int) o1[0] == (int) o2[0]) {
                return ((String) o1[1]).compareTo((String) o2[1]);
            } else {
                return (int) o1[0] - (int) o2[0];
            }
        }));

        PriorityQueue<Object[]> pqRight = new PriorityQueue<>(((o1, o2) -> {
            if ((int) o1[0] == (int) o2[0]) {
                return ((String) o1[2]).compareTo((String) o2[1]);
            } else {
                return (int) o2[0] - (int) o1[0];
            }
        }));
        int count = 0;

        public SORTracker() {

        }

        public void add(String name, int score) {
            Object[] objects = new Object[]{score, name};
            if (pqRight.isEmpty()) {
                pqLeft.add(objects);
            } else {
                pqRight.add(objects);
                Object[] objs = pqRight.poll();
                pqLeft.add(objs);
            }
        }

        public String get() {
            Object[] objs = pqLeft.poll();
            pqRight.add(objs);
            return (String)objs[1];
        }
    }
}
