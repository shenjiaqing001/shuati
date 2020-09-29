import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/9/29
 */
public class lc406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });

        List<int[]> list = new LinkedList<>();

        for (int i = 0; i < people.length; ++i) {
            int pos = people[i][1];
            list.add(pos, people[i]);
        }

        int[][] res = new int[people.length][2];
        int pos = 0;
        for (int[] p : list) {
            res[pos++] = p;
        }

        return res;
    }
}
