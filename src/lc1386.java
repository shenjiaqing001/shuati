import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/11/4
 */
public class lc1386 {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < reservedSeats.length; ++i) {
            map.putIfAbsent(reservedSeats[i][0], new HashSet<>());
            map.get(reservedSeats[i][0]).add(reservedSeats[i][1]);
        }

        int res = 0;
        int keys = map.keySet().size();
        res += (n - keys) * 2;
        for (Set<Integer> set : map.values()) {
            int tmp = 0;
            if (!set.contains(3) && !set.contains(4) && !set.contains(5) && !set.contains(2)) tmp ++;
            if (!set.contains(6) && !set.contains(7) && !set.contains(8) && !set.contains(9)) tmp ++;
            if(tmp > 0) res += tmp;
            else {
                if (!set.contains(4) && !set.contains(5) && !set.contains(6) && !set.contains(7))
                    res ++;
            }

        }
        return res;
    }
}
