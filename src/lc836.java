/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/25
 */
public class lc836 {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        if (rec1[2] <= rec2[0] || rec1[0] >= rec2[2]) return false;
        if (rec1[3] <= rec2[1] || rec1[1] >= rec2[3]) return false;
        return true;
    }
}
