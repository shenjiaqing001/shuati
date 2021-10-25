package OnlineInterview;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/24
 */
public class Google {
    //bananana-> b,a,n,an,ana
    //bananaana-> b,a,n,an,a,ana
    Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        Google test = new Google();
        System.out.println(test.solution("bananaana"));
    }

    public boolean check(String s, int right) {
        for (int i = 0; i < s.length(); ++i) {
            String sub = s.substring(0, i) + s.substring(i + 1);
            if (map.containsKey(sub)) {
                if (map.get(sub) < right) return true;
            }
        }
        return false;
    }

    public int solution(String s) {
        int max = 0;
        map.put("", -1);
        for (int i = 0; i < s.length(); ++i) {
            int left = i;
            while (left >= 0) {
                String str = s.substring(left, i + 1);
                if (check(str, left)) {
                    max = Math.max(max, i - left + 1);
                    if (!map.containsKey(str)) {
                        map.put(str, i);
                    }
                    left--;
                } else {
                    break;
                }
            }
        }
        System.out.println(map);
        return max;
    }

}
