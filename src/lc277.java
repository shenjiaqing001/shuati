/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/9
 */
public class lc277 {
    /* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */
    boolean knows(int a, int b) {
        return true;
    }

    public int findCelebrity(int n) {
        int candidate = 0;
        for (int i = 1; i < n; ++i) {
            if (knows(candidate, i)) candidate = i;
        }
        for (int i = 0; i < n; ++i) {
            if (candidate == i) continue;
            if (knows(candidate, i)) return -1;
            if (!knows(i, candidate)) return -1;
        }

        return candidate;
    }
}
