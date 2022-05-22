package WeeklyContest293;

import java.util.TreeSet;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 5/14/22
 */
public class lc2 {
    public int maxConsecutive(int bottom, int top, int[] special) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int s : special) set.add(s);
        int max = top - set.last();
        int last = bottom - 1;
        for (int key : set) {
            max = Math.max(key - last - 1, max);
            last = key;
        }
        return max;
    }
}
