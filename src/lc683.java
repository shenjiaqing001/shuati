import java.util.TreeSet;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 1/17/22
 */
public class lc683 {
    public int kEmptySlots(int[] bulbs, int k) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        int time = 1;
        for (int bulb : bulbs) {
            Integer floor = treeSet.floor(bulb);
            if (floor != null && bulb - floor == k + 1) return time;
            Integer ceiling = treeSet.ceiling(bulb);
            if (ceiling != null && ceiling - bulb == k + 1) return time;
            treeSet.add(bulb);
            time++;
        }
        return -1;
    }
}
