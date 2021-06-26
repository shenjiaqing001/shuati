import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/6/24
 */
public class lc792 {
    public int numMatchingSubseq(String S, String[] words) {
        int n = words.length;
        Map<Character, Queue<String>> map = new HashMap<>();
        for (String word : words) {
            char c = word.charAt(0);
            map.putIfAbsent(c, new LinkedList<>());
            map.get(c).add(word);
        }

        int res = 0;
        for (char c : S.toCharArray()) {
            if (map.containsKey(c)) {
                Queue<String> q = map.get(c);
                System.out.println(q.size());
                int size = q.size();
                for (int i = 0; i < size; ++i) {
                    String word = q.poll();
                    if (word.length() == 1) res++;
                    else {
                        char c1 = word.charAt(1);
                        map.putIfAbsent(c1, new LinkedList<>());
                        map.get(c1).add(word.substring(1));
                        System.out.println(c1 + " " + map.get(c1).size());
                    }
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        lc792 test = new lc792();
        test.numMatchingSubseq("abcde", new String[]{"a", "bb", "acd", "ace"});
    }
}
