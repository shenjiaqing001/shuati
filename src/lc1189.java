/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/9/14
 */
public class lc1189 {
    public int maxNumberOfBalloons(String text) {
        int[] count = new int[26];
        for (char c : text.toCharArray()) {
            count[c - 'a']++;
        }
        int res = text.length();
//        balloon
        res = Math.min(res, count['b' - 'a']);
        res = Math.min(res, count['a' - 'a']);
        res = Math.min(res, count['l' - 'a'] / 2);
        res = Math.min(res, count['o' - 'a'] / 2);
        res = Math.min(res, count['n' - 'a']);
        return res;
    }
}
