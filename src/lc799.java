/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/26
 */
public class lc799 {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[] glasses = new double[101];
        glasses[0] = poured;
        for (int i = 1; i <= query_row; ++i) {
            double[] newLine = new double[101];
            for (int j = 0; j < i; j++) {
                if (glasses[j] > 1) {
                    newLine[j] += (glasses[j] - 1) / 2.0;
                    newLine[j + 1] += (glasses[j] - 1) / 2.0;
                }
            }
            glasses = newLine;
        }
        return glasses[query_glass] > 1 ? 1 : glasses[query_glass];
    }
}
