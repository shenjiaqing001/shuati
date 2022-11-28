package WeeklyContest308;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/27/22
 */
public class lc3 {

    public int gb(String[] garbage, int[] travel, char type) {
        int res = 0;
        int tmpSum = 0;

        for (int i = 0; i < garbage.length; ++i) {
            for (char c : garbage[i].toCharArray()) {
                if (c == type) {
                    res += tmpSum;
                    tmpSum = 0;
                    res++;
                }
            }
            if (i != garbage.length - 1) {
                tmpSum += travel[i];
            }
        }
        return res;
    }

    public int garbageCollection(String[] garbage, int[] travel) {
        int res = 0;
        res += gb(garbage, travel, 'P');
        res += gb(garbage, travel, 'G');
        res += gb(garbage, travel, 'M');
        return res;
    }
}
