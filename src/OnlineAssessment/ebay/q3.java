package OnlineAssessment.ebay;

import java.util.Arrays;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/9
 */
public class q3 {

    boolean check(String className, String methodName) {
        if (className.length() != methodName.length()) return false;
        int[] a = new int[26];
        int[] b = new int[26];
        for (char c : className.toCharArray()) {
            a[c - 'a']++;
        }
        for (char c : methodName.toCharArray()) {
            b[c - 'a']++;
        }

        for (int i = 0; i < 26; ++i) {
            if (a[i] == 0 && b[i] != 0) return false;
            if (a[i] != 0 && b[i] == 0) return false;
        }

        Arrays.sort(a);
        Arrays.sort(b);
        for (int i = 0; i < 26; ++i) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

}
