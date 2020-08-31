/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/25/20
 */
public class lc97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        boolean[][] thisWayNoPass =
                new boolean[s1.length() + 5][s2.length() + 5];
        if (s1.length() + s2.length() != s3.length()) return false;
        return recursive(thisWayNoPass, s1, s2, s3, 0, 0);
    }


    public boolean recursive(boolean[][] thisWayNoPass, String s1, String s2,
                             String s3, int p1, int p2) {
        if (p1 == s1.length() && p2 == s2.length())
            return true;
        if (thisWayNoPass[p1][p2] == true)
            return false;

        boolean go1 = p1 < s1.length() && s1.charAt(p1) == s3.charAt(p1 + p2) &&
                recursive(thisWayNoPass, s1, s2, s3, p1 + 1, p2);

        boolean go2 = p2 < s2.length() && s2.charAt(p2) == s3.charAt(p1 + p2) &&
                recursive(thisWayNoPass, s1, s2, s3, p1, p2 + 1);
        if (!(go1 || go2)) thisWayNoPass[p1][p2] = true;
        return (go1 || go2);
    }

    public static void main(String[] args) {
        lc97 t = new lc97();
        System.out.println(t.isInterleave("a","b","ab"));
    }

}
