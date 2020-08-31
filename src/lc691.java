import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/26/20
 */
public class lc691 {
    public int minStickers(String[] stickers, String target) {
        int[][] words = new int[stickers.length][26];
        for (int i = 0; i < stickers.length; ++i) {
            for (int j = 0; j < stickers[i].length(); ++j) {
                words[i][stickers[i].charAt(j) - 'a']++;
            }
        }
        Map<String, Integer> dp = new HashMap<>();
        dp.put("", 0);
        return helper(dp, words, target);
    }

    public int helper(Map<String, Integer> dp, int[][] words, String target) {
        if (dp.containsKey(target)) return dp.get(target);
        int[] c = new int[26];
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < target.length(); ++i) {
            c[target.charAt(i) - 'a']++;
        }
        for (int i = 0; i < words.length; ++i) {
            if (words[i][target.charAt(0) - 'a'] == 0) continue;

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 26; j++) {
                if (c[j] > 0)
                    for (int k = 0; k < Math.max(0, c[j] - words[i][j]); k++)
                        sb.append((char) ('a' + j));
            }
            String s = sb.toString();
            int tmp = helper(dp, words, s);
            if (tmp != -1) res = Math.min(res, 1 + tmp);
        }
        dp.put(target, res == Integer.MAX_VALUE ? -1 : res);
        return dp.get(target);
    }
}