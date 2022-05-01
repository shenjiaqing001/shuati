package WeeklyContest287;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 4/2/22
 */
public class lc4 {
    class Encrypter {
        Map<Character, String> map = new HashMap<>();
        Map<Long, Integer> dic = new HashMap<>();

        public long getHash(String s) {
            long base = 27;
            long pow = 1;
            long res = 0;
            for (char c : s.toCharArray()) {
                String s1 = map.get(c);
                res += pow * (s1.charAt(0) - 'a' + 1);
                pow *= base;
                res += pow * (s1.charAt(1) - 'a' + 1);
                pow *= base;
            }
            return res;
        }


        public Encrypter(char[] keys, String[] values, String[] dictionary) {
            for (int i = 0; i < keys.length; ++i) {
                map.put(keys[i], values[i]);
            }
            System.out.println(map);
            for (String s : dictionary) {
                long hash = getHash(s);
                dic.put(hash, dic.getOrDefault(hash, 0) + 1);
            }
        }

        public String encrypt(String word1) {
            StringBuilder sb = new StringBuilder();
            for (char c : word1.toCharArray()) {
                sb.append(map.get(c));
            }
            return sb.toString();
        }


        public int decrypt(String word2) {
            long base = 27;
            long pow = 1;
            long res = 0;
            for (char c : word2.toCharArray()) {
                res += pow * (c - 'a' + 1);
                pow *= base;
            }
            return dic.getOrDefault(res, 0);
        }
    }
}
