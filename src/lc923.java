import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/9/25
 */
public class lc923 {
    public int threeSumMulti(int[] A, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < A.length; ++i) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
            if (map.get(A[i]) == 1) list.add(A[i]);
        }

        Map<Integer, List<int[]>> addMap = new HashMap();
        for (int i = 0; i < list.size(); ++i) {
            for (int j = i + 1; j < list.size(); ++j) {
                int sum = list.get(i) + list.get(j);
                addMap.putIfAbsent(sum, new ArrayList<>());
                addMap.get(sum).add(new int[]{list.get(i), list.get(j)});
            }
        }
        long res1 = 0;

        for (int i = 0; i < list.size(); ++i) {
            int num = list.get(i);
            if (!addMap.containsKey(target - num)) continue;
            for (int[] tmp : addMap.get(target - num)) {
                if (tmp[0] != num && tmp[1] != num) {
                    long mul = map.get(num) * map.get(tmp[0]) * map.get(tmp[1]);
                    res1 += mul;
                }
            }
        }
        res1 /= 3;

        long res2 = 0;
        for (int i = 0; i < list.size(); ++i) {
            int num = list.get(i);
            if (!addMap.containsKey(target - num)) continue;
            for (int[] tmp : addMap.get(target - num)) {
                if (tmp[0] == num || tmp[1] == num) {
                    if (map.get(num) == 1) continue;
                    long mul = (map.get(num) - 1) * map.get(tmp[0]) * map.get(tmp[1]) / 2;
                    res2 += mul;
                }
            }
        }
        long res3 = 0;
        if (target % 3 == 0 && map.containsKey(target / 3) && map.get(target / 3) >= 3) {
            long tmp = map.get(target / 3);
            res3 = tmp * (tmp - 1) * (tmp - 2) / 6;
        }
        System.out.println(res1 + " " + res2 + " " + res3);
        return (int) (res1 + res2 + res3 % 1000000007);
    }
}
