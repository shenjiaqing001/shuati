import java.util.Arrays;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/11/11
 */
public class lc1037 {
    public boolean isBoomerang(int[][] points) {
        // a2 = l1;
        // b2 = l2;
        // c2 = l3;
        // a + b = c;
        // a2 + b2 + 2ab = c2;
        // 2ab = c2-a2-b2;
        // 4a2b2 = (c2-a2-b2)2

        int l1 = (points[0][0] - points[1][0]) * (points[0][0] - points[1][0]) +
                (points[0][1] - points[1][1]) * (points[0][1] - points[1][1]);
        int l2 = (points[0][0] - points[2][0]) * (points[0][0] - points[2][0]) +
                (points[0][1] - points[2][1]) * (points[0][1] - points[2][1]);
        int l3 = (points[2][0] - points[1][0]) * (points[2][0] - points[1][0]) +
                (points[2][1] - points[1][1]) * (points[2][1] - points[1][1]);
        if (4 * l1 * l2 == (l3 - l1 - l2) * (l3 - l1 - l2)) return false;
        else return true;

    }
}
