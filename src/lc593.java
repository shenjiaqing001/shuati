/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/11/12
 */
public class lc593 {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        long a = (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
        long b = (p3[0] - p4[0]) * (p3[0] - p4[0]) + (p3[1] - p4[1]) * (p3[1] - p4[1]);
        if (a != b) return false;

        long c = (p3[0] - p2[0]) * (p3[0] - p2[0]) + (p3[1] - p2[1]) * (p3[1] - p2[1]);
        long d = (p1[0] - p4[0]) * (p1[0] - p4[0]) + (p1[1] - p4[1]) * (p1[1] - p4[1]);
        if (c != d) return false;

        long e = (p4[0] - p2[0]) * (p4[0] - p2[0]) + (p4[1] - p2[1]) * (p4[1] - p2[1]);
        long f = (p3[0] - p1[0]) * (p3[0] - p1[0]) + (p3[1] - p1[1]) * (p3[1] - p1[1]);
        if (e != f) return false;


        if (a != c && a != e && c != e) return false;
        if (a == 0 || c == 0 || e == 0) return false;
        return true;
    }
}
