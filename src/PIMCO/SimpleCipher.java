package PIMCO;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/18
 */
public class SimpleCipher {
    public static String simpleCipher(String encrypted, int k) {
        // Write your code here
        k %= 26;
        StringBuilder sb = new StringBuilder(encrypted);
        for (int i = 0; i < sb.length(); ++i) {
            char c = sb.charAt(i);
            c -= k;
            if (c < 'A') c += 26;
            sb.setCharAt(i, c);
        }
        return sb.toString();
    }

}
