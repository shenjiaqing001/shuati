package WeeklyContest293;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 5/14/22
 */
public class lc3 {
    public int largestCombination(int[] candidates) {
        int[] count = new int[30];
        for (int candidate : candidates) {
            int index = 0;
            while (candidate > 0) {
                if (candidate % 2 == 1) count[index]++;
                index++;
                candidate /= 2;
            }
        }
        int max = 0;
        for (int i = 0; i < count.length; ++i) {
            max = Math.max(max, count[i]);
        }
        return max;
    }
}
