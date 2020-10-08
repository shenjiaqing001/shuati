import java.util.TreeSet;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/8
 */
public class lc855 {
    class ExamRoom {
        TreeSet<Integer> set = new TreeSet<>();
        int total;

        public ExamRoom(int N) {
            this.total = N;
            set.add(N * 3);
        }

        public int seat() {
            for (Integer i : set) System.out.print(i + " ");
            System.out.println();
            if (set.size() == 1) {
                set.add(0);
                return 0;
            }
            int max = 0;
            int res = -1;
            int last = -total;
            for (Integer location : set) {
                if (last < 0) {
                    last = 0;
                    if (set.contains(0)) continue;
                    if (location > max) {
                        max = location;
                        res = 0;
                    }
                } else if (location >= total) {
                    if (set.contains(total - 1)) continue;
                    int now = total - 1 - last;
                    if (now > max) {
                        max = now;
                        res = total - 1;
                    }
                } else {
                    int now = (location + last) / 2;
                    int diff = now - last;
                    if (diff > max) {
                        max = diff;
                        res = now;
                    }
                }
                last = location;
            }
            set.add(res);
            return res;
        }

        public void leave(int p) {
            set.remove(p);
        }
    }
}
