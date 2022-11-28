package WeeklyContest312;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/24/22
 */
public class lc1 {
    public String[] sortPeople(String[] names, int[] heights) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < names.length; ++i) {
            list.add(new int[]{i, heights[i]});
        }
        list.sort((o1, o2) -> (o2[1] - o1[1]));
        String[] res = new String[names.length];
        for (int i = 0; i < list.size(); ++i) {
            res[i] = names[list.get(i)[0]];
        }
        return res;
    }
}
