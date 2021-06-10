/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/2/22
 */
public class lc991 {
    public int brokenCalc(int X, int Y) {

        int count = 0;
        while (Y > X) {
            if (Y % 2 == 0) Y /= 2;
            else Y += 1;
            count++;
        }
        return count + X - Y;
    }
}
