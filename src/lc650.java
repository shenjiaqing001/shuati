import java.util.LinkedList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/14/20
 */
public class lc650 {
    public int minSteps(int n) {
        List<int[]> factors = new LinkedList<>();
        int num = n;
        int[] steps = new int[]{0, 1, 2, 3, 4, 5, 5, 7, 6, 6};
        for (int i = 2; i <= n; ++i) {
            if (num % i == 0) {
                int times = 0;
                while (num % i == 0) {
                    times++;
                    num /= i;
                }
                factors.add(new int[]{i, times});
            }
        }
        int res = 0;

        for (int[] i : factors) {
            System.out.println(i[0] + " " + i[1]);
            res += steps[i[1]] * i[0];
        }
        return res;
    }

    public static void main(String[] args) {
        lc650 t = new lc650();
        System.out.println(t.minSteps(1000));
    }
}
