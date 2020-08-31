package weeklycontest202;

import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/16/20
 */
public class lc1553 {
    public int minDays(int n) {
        List<Integer> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        q.add(n);
        int res = 0;
        while (q.size() > 0) {
            List<Integer> newList = new LinkedList<>();
            for (Integer i : q) {
                if (i == 0) return res;
                if (i % 3 == 0) {
                    if (!set.contains(i % 3)) {
                        newList.add(i / 3);
                        set.add(i / 3);
                    }
                }
                if (i % 2 == 0) {
                    if (!set.contains(i % 2)) {
                        newList.add(i / 2);
                        set.add(i / 2);
                    }
                }
                if (!set.contains(i - 1)) {
                    newList.add(i - 1);
                    set.add(i - 1);
                }
            }
            res++;
            q = newList;
        }
        return res;
    }

    //
    //64 63 21 7 6 2 1 0
    //64 32 16 8 4 2 1 0


    public static void main(String[] args) {
        lc1553 t = new lc1553();
        System.out.println(t.minDays(429));
    }
}
