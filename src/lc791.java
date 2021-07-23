

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/14
 */
public class lc791 {
    public String customSortString(String order, String str) {
        int[] count = new int[26];
        for (char c : str.toCharArray()) {
            count[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : order.toCharArray()) {
            for (int i = 0; i < count[c - 'a']; ++i)
                sb.append(c);
            count[c - 'a'] = 0;
        }
        for (char c : str.toCharArray()) {
            if (count[c - 'a'] != 0)
                sb.append(c);
        }

        return sb.toString();
    }
}
