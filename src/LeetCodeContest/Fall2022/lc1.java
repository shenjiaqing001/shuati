package LeetCodeContest.Fall2022;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/24/22
 */
public class lc1 {

    public int getType(int t1, int t2) {
        if (t1 == t2) return 0;
        if (t1 > t2) return -1;
        return 1;
    }

    public int temperatureTrend(int[] temperatureA, int[] temperatureB) {
        int max = 0;
        int n = temperatureA.length;
        int count = 0;
        for (int i = 0; i < n - 1; ++i) {
            int typeA = getType(temperatureA[i], temperatureA[i + 1]);
            int typeB = getType(temperatureB[i], temperatureB[i + 1]);
            if (typeA == typeB) {
                count++;
            } else {
                count = 0;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
