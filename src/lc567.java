/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/27/20
 */
public class lc567 {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] tar = new int[26];
        for (char c : s1.toCharArray()) {
            tar[c - 'a']++;
        }
        int count = s1.length();
        int k = s1.length();
        char[] str = s2.toCharArray();
        for (int i = 0; i < k; ++i) {
            if (tar[str[i] - 'a']-- >= 1) {
                count--;
            }
        }

        if (count == 0) return true;
        for (int i = k; i < str.length; ++i) {
            if (tar[str[i - k] - 'a']++ >= 0) {
                count++;
            }
            if (tar[str[i] - 'a']-- >= 1) {
                count--;
            }
            if (count == 0) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        lc567 t = new lc567();
        System.out.println(t.checkInclusion("adc","dcda"));
    }
}
