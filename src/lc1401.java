/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/2/20
 */
public class lc1401 {
    public boolean checkOverlap(int radius, int x_center, int y_center, int x1, int y1, int x2,
                                int y2) {
        int disx = (x_center >= x1 && x_center <= x2) ? 0 : Math
                .min(Math.abs(x_center - x1), Math.abs(x_center - x2));
        int disy = (y_center >= y1 && y_center <= y2) ? 0 : Math
                .min(Math.abs(y_center - y1), Math.abs(y_center - y2));


        return disx * disx + disy * disy <= radius * radius;
    }
}
