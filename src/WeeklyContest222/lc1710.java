package WeeklyContest222;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/1/3
 */
public class lc1710 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (o1, o2) -> (o2[1] - o1[1]));
        int index = 0;
        int res = 0;
        while (index < boxTypes.length && truckSize >= boxTypes[index][0]) {
            res += boxTypes[index][0] * boxTypes[index][1];
            truckSize -= boxTypes[index][0];
            index++;
        }
        if (index == boxTypes.length) return res;
        res += boxTypes[index][1] * truckSize;
        return res;
    }
}
