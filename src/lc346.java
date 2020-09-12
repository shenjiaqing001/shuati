import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/12/20
 */
public class lc346 {
    class MovingAverage {
        Double sum = 0.0;
        List<Integer> list = new LinkedList<>();
        int size = 0;

        /**
         * Initialize your data structure here.
         */
        public MovingAverage(int size) {
            this.size = size;

        }

        public double next(int val) {
            sum += val;
            list.add(val);

            if (list.size() > size)
                sum -= list.remove(0);
            return sum / list.size();
        }
    }
}
