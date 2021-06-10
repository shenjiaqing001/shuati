/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/5/27
 */
public class lc318 {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] mask = new int[n];
        int max = 0;
        for (int i = 0; i < n; ++i) {
            for (char c : words[i].toCharArray()) {
                mask[i] |= 1 << (c - 'a');
            }
        }

        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if ((mask[i] & mask[j]) == 0) {
                    max = Math.max(words[i].length() * words[j].length(), max);
                }
            }
        }

        return max;
    }
}
