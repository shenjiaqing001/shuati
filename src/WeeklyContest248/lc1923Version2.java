package WeeklyContest248;

import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/5
 */
public class lc1923Version2 {
    public int longestCommonSubpath(int n, int[][] paths) {
        List<List<Integer>> list = new ArrayList<>();

        int id = 0;
        for (int[] path : paths) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(id);
            for (int i = path.length - 1; i >= 0; --i) {
                tmp.add(0, path[i]);
                list.add(new ArrayList<>(tmp));
            }
            id++;
        }

        list.sort(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                int index = 0;
                while (index < o1.size() - 1 && index < o2.size() - 1) {
                    int n1 = o1.get(index);
                    int n2 = o2.get(index);
                    if (n1 > n2) return -1;
                    else if (n1 < n2) return 1;
                    index++;
                }
                if (o1.size() < o2.size()) return -1;
                if (o1.size() > o2.size()) return 1;
                return 0;
            }
        });


        int max = 0;
        for (int i = 0; i < list.size(); ++i) {
            Set<Integer> set = new HashSet<>();
            List<Integer> route = new LinkedList<>(list.get(i));
            set.add(route.get(route.size() - 1));
            route.remove(route.size() - 1);

            for (int j = i + 1; j < list.size(); ++j) {
                List<Integer> tmp = list.get(j);
                if (!route.get(0).equals(tmp.get(0))) break;
                int index;
                for (index = 0; index < route.size(); index++) {
                    if (!route.get(index).equals(tmp.get(index))) break;
                }
                while (route.size() > index) route.remove(route.size() - 1);
                set.add(tmp.get(tmp.size() - 1));
                if (set.size() == paths.length) {
                    max = Math.max(max, route.size());
                    break;
                }
            }
        }
        return max;
    }
}
