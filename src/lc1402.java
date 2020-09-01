import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/2/20
 */
public class lc1402 {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int right = satisfaction.length - 1;
        int last = 0;
        int sum = 0;
        while (right >= 0) {
            sum += satisfaction[right];
            int now = last + sum;
            if (now > last) {
                last = now;
            } else
                return last;
            right--;
        }
        return last;
    }
}
