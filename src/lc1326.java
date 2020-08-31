import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/29/20
 */
public class lc1326 {
    public int minTaps(int n, int[] ranges) {

        ArrayList<int[]> list = new ArrayList<>();

        for (int i = 0; i <= n; ++i) {
            if (ranges[i] != 0)
                list.add(new int[]{i - ranges[i], i + ranges[i]});
        }
        list.sort(Comparator.comparingInt(o -> o[0]));

        int res = 0;
        int now = 0;
        int index = 0;
        while (true) {
            int max = 0;
            for (int i = index; i < list.size(); ++i) {
                if (list.get(i)[0] > now) {
                    index = i;
                    break;
                }
                max = Math.max(max, list.get(i)[1]);
            }
            res++;
            if (max <= now) return -1;
            if (now >= n) return res;
            now = max;
            System.out.println(now);
        }
    }
}
