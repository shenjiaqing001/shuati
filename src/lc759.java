import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/9/20
 */
public class lc759 {
    private class Interval {
        public int start;
        public int end;

        public Interval() {
        }

        public Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }


    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> total = new ArrayList<>();
        for (List<Interval> list : schedule)
            total.addAll(list);
        total.sort(Comparator.comparingInt(o -> o.start));

        List<Interval> res = new LinkedList<>();
        int last = -1;
        for (Interval interval : total) {
            if (last == -1) {
                last = interval.end;
                continue;
            }
            if (last < interval.start) {
                res.add(new Interval(last, interval.start));
                last = interval.end;
            } else {
                last = Math.max(last, interval.end);
            }
        }
        return res;
    }
}
