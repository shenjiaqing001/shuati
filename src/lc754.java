/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/12/29
 */
public class lc754 {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int step = 0;
        int sum = 0;
        while (sum < target) {
            step++;
            sum += step;
        }
        while ((sum - target) % 2 != 0) {
            step++;
            sum += target;
        }
        return step;
    }
}
