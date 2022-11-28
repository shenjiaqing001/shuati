package WeeklyContest307;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/20/22
 */
public class lc1 {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy,
                                int[] experience) {
        int sum = 0;
        for (int e : energy) {
            sum += e;
        }
        int res = Math.max(2, sum + 1 - initialEnergy);

        int nowExp = initialExperience;
        for (int e : experience) {
            if (nowExp < e + 1) {
                res += e + 1 - nowExp;
                nowExp = 2 * e + 1;
            } else {
                nowExp += e;
            }
        }
        return res;
    }
}
