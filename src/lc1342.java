/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/2/16
 */
public class lc1342 {
    public int numberOfSteps(int num) {
        int steps = 0;
        while (num != 0) {
            if (num % 2 == 0) num /= 2;
            else num -= 1;
            steps++;
        }
        return steps;
    }
}
