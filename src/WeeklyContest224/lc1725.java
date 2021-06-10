package WeeklyContest224;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/1/17
 */
public class lc1725 {
    public int countGoodRectangles(int[][] rectangles) {
        int max = 0;
        int count = 0;
        for (int i = 0; i < rectangles.length; ++i) {
            int min = Math.min(rectangles[i][0], rectangles[i][1]);
            if (min > max) {
                max = min;
                count = 1;
            } else if (min == max) {
                count++;
            }
        }
        return count;
    }
}
