package BiWeeklyContest55;

import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/6/26
 */
public class lc1912 {

    // shop movie price.

    class MovieRentingSystem {
        Map<Integer, TreeSet<int[]>> map = new HashMap<>();
        TreeSet<int[]> rented =
                new TreeSet<>(new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        if (o1[2] != o2[2]) return o1[2] - o2[2];
                        if (o1[0] != o2[0]) return o1[0] - o2[0];
                        return o1[1] - o2[1];
                    }
                });
        int n = 0;
        Map<Integer, Map<Integer, int[]>> shopMap = new HashMap<>();  // shop movie entry

        public MovieRentingSystem(int n, int[][] entries) {
            this.n = n;
            for (int[] enrty : entries) {
                if (!map.containsKey(enrty[1])) {
                    map.put(enrty[1], new TreeSet<>(
                            (o1, o2) -> o1[2] == o2[2] ? o1[0] - o2[0] : o1[2] - o2[2]));
                }
                map.get(enrty[1]).add(enrty);
                if (!shopMap.containsKey(enrty[0])) {
                    shopMap.put(enrty[0], new HashMap<>());
                }
                shopMap.get(enrty[0]).put(enrty[1], enrty);
            }
        }

        public List<Integer> search(int movie) {
            List<Integer> list = new LinkedList<>();
            if (!map.containsKey(movie)) return list;
            for (int[] entry : map.get(movie)) {
                if (list.size() >= 5) break;
                list.add(entry[0]);
            }
            return list;
        }

        public void rent(int shop, int movie) {
            int[] entry = shopMap.get(shop).get(movie);
            rented.add(entry);
            map.get(entry[1]).remove(entry);
        }

        public void drop(int shop, int movie) {
            int[] entry = shopMap.get(shop).get(movie);
            rented.remove(entry);
            map.get(entry[1]).add(entry);
        }

        public List<List<Integer>> report() {
            List<List<Integer>> res = new ArrayList<>();
            if (rented.size() == 0) return res;
            for (int[] entry : rented) {
                if (res.size() >= 5) break;
                List<Integer> tmp = new LinkedList<>();
                tmp.add(entry[0]);
                tmp.add(entry[1]);
                res.add(tmp);
            }

            return res;
        }
    }

    public static void main(String[] args) {

    }
}
