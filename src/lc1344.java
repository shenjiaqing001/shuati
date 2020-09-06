/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/6/20
 */
public class lc1344 {
    public double angleClock(int hour, int minutes) {
        double hourPointer = (hour % 12) * 30;
        double minutesPointer = minutes * 6;

        hourPointer += 0.5 * minutes;

        double res = Math.abs(hourPointer - minutesPointer);
        if (res >= 180) res = 360 - res;

        return res;
    }
}
