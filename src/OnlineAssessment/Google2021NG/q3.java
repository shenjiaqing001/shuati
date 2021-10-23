package OnlineAssessment.Google2021NG;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/21
 */
public class q3 {

    public static void main(String[] args) {
        q3 test = new q3();
        System.out.println(test.solution(new String[]{"nn", "nn", "nn", "kc"}));
    }

    public int solution(String[] A) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : A) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        int res = 0;
        for (char a = 'a'; a <= 'z'; ++a) {
            for (char b = a; b <= 'z'; ++b) {
                if (a == b) {
                    String s = a + String.valueOf(b);
                    if (map.containsKey(s)) {
                        int num = map.get(s);
                        res += num / 2 * 4;
                        map.put(s, num % 2);
                        if (map.get(s) == 0) map.remove(s);
                    }
                } else {
                    String s1 = a + String.valueOf(b);
                    String s2 = b + String.valueOf(a);
                    if (map.containsKey(s1) && map.containsKey(s2)) {
                        int c1 = map.get(s1);
                        int c2 = map.get(s2);
                        int min = Math.min(c1, c2);
                        res += min * 4;
                        map.put(s1, c1 - min);
                        map.put(s2, c2 - min);
                    }
                }
            }
        }

        for (char a = 'a'; a <= 'z'; ++a) {
            String s = a + String.valueOf(a);
            if (map.containsKey(s)) {
                res += 2;
                break;
            }
        }
        return res;
    }
}
