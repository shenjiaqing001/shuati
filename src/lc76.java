/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/22/20
 */
public class lc76 {
    public String minWindowold(String s, String t) {
        if (s.length() < t.length() || s.length() == 0 || t.length() == 0)
            return "";
        int[] tChars = new int[128];
        int[] sChars = new int[128];

        for (int i = 0; i < t.length(); ++i) {
            tChars[t.charAt(i)]++;
        }
        int flag = 0;
        for (int i = 0; i < 128; ++i) {
            if (tChars[i] > 0)
                flag++;
        }

        int left = 0;
        int right = 0;
        int count = 0;
        int max = s.length() + 1;
        String res = "";

        while (right < s.length()) {
            if (tChars[s.charAt(right)] > 0) {
                sChars[s.charAt(right)]++;
                if (tChars[s.charAt(right)] == sChars[s.charAt(right)])
                    count++;
            }

            right++;

            while (count == flag) {
                int now = right - left;
                if (max > now) {
                    max = now;
                    res = s.substring(left, right);
                }
                if (tChars[s.charAt(left)] > 0) {
                    sChars[s.charAt(left)]--;
                    if (sChars[s.charAt(left)] < tChars[s.charAt(left)])
                        count--;
                }
                left++;
            }
        }
        return res;
    }

    public String minWindow(String s, String target) {
        int[] tar = new int[128];
        for (char c : target.toCharArray()) {
            tar[c]++;
        }

        int left = 0;
        int right = 0;
        String res = "";
        int count = target.length();
        while (right < s.length()) {
            if (tar[s.charAt(right)] >= 1) {
                count--;
            }
            tar[s.charAt(right)]--;
            right++;

            while (count == 0 && left <= right) {
                if (res == "" || res.length() > right - left) {
                    res = s.substring(left, right);
                }
                if (tar[s.charAt(left)] >= 0) {
                    count++;
                }
                tar[s.charAt(left)]++;
                left++;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        lc76 t = new lc76();

        System.out.println(t.minWindow("aa", "aa"));
    }

}
