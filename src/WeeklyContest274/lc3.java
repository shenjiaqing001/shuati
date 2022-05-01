package WeeklyContest274;

import java.util.Arrays;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 1/1/22
 */
public class lc3 {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        long now = mass;
        Arrays.sort(asteroids);
        for (int as : asteroids) {
            if (now >= as) {
                now += as;
            } else return false;
        }
        return true;
    }
}
