package WeeklyContest300;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/2/22
 */
public class lc1 {
    public String decodeMessage(String key, String message) {
        int[] keys = new int[26];
        int index = 0;
        Set<Character> set = new HashSet<>();
        for (char c : key.toCharArray()) {
            if(c == ' ') continue;;
            if (!set.contains(c)) {
                keys[c - 'a'] = index++;
                set.add(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (c == ' ') sb.append(' ');
            else sb.append(((char) (keys[c - 'a'] + 'a')));
        }
        return sb.toString();
    }
}
