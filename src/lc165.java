/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/15/20
 */
public class lc165 {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int flag = 1;
        if (v1.length > v2.length) {
            String[] tmp = v1;
            v1 = v2;
            v2 = tmp;
            flag = -1;
        }
        for (String s : v1) System.out.println(s);

        for (int i = 0; i < v1.length; ++i) {
            int now1 = Integer.valueOf(v1[i]);
            if (v2.length <= i) {
                if (now1 > 0) return 1 * flag;
            } else {
                int now2 = Integer.valueOf(v2[i]);
                if (now1 < now2) return -1 * flag;
                if (now1 > now2) return 1 * flag;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        lc165 t = new lc165();
        System.out.println(t.compareVersion("0.1","1.1"));
    }
}
