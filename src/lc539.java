import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/10
 */
public class lc539 {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> list = new ArrayList<>();
        for (String str : timePoints) {
            int h = Integer.valueOf(str.substring(0, 2)) * 60;
            int s = Integer.valueOf(str.substring(3, 5));
            list.add(h + s);
        }
        list.sort((o1, o2) -> o1 - o2);
        int min = 1440;
        for (int i = 1; i < list.size(); ++i) {
            min = Math.min(min, list.get(i) - list.get(i - 1));
        }
        min = Math.min(min, list.get(0) + 1440 - list.get(list.size() - 1));
        return min;
    }
}
