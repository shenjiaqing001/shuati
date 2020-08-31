import org.w3c.dom.ls.LSOutput;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/13/20
 */
public class lc159 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s.length() <= 2) return s.length();

        char[] c = s.toCharArray();
        int max = 0;
        int tmp = 0;
        int pos1 = -1;
        int pos2 = -1;

        for (int i = 0; i < c.length; ++i) {
            if (pos1 == -1) {
                pos1 = i;
                tmp = 1;
            } else if (s.charAt(i) == s.charAt(i - 1)) {
                tmp++;
            } else {
                if (pos2 == -1) {
                    pos2 = i;
                    tmp++;
                } else {
                    if (s.charAt(pos1) == s.charAt(i)) {
                        pos1 = pos2;
                        pos2 = i;
                        tmp++;
                    } else {
                        pos1 = pos2;
                        pos2 = i;
                        max = Math.max(tmp, max);
                        tmp = i - pos1 + 1;
                    }
                }
            }
        }
        max = Math.max(tmp, max);
        return max;
    }


    public static void main(String[] args) {
        lc159 t = new lc159();
        System.out.println(t.lengthOfLongestSubstringTwoDistinct("ccaaccbbb"));
    }
}
