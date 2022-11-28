package WeeklyContest297;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 6/11/22
 */
public class lc1 {
    public double calculateTax(int[][] brackets, int income) {
        double res = 0;
        int last = 0;
        for (int[] bracket : brackets) {

            res += (Math.min(bracket[0], income) - last) * (bracket[1]) / 100.0;

            last = bracket[0];
            if (bracket[0] > income) break;
        }
        return res;
    }

    public static void main(String[] args) {
        lc1 test = new lc1();
        test.calculateTax(new int[][]{{3, 50}, {7, 10}, {12, 25}}, 10);
    }
}
