import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/30
 */
public class lc677 {
    static class MapSum {
        public class Trie {
            int sum = 0;
            Trie[] children = new Trie[26];
        }

        Trie root = new Trie();
        Map<String, Integer> map = new HashMap<>();

        /**
         * Initialize your data structure here.
         */
        public MapSum() {

        }

        public void insert(String key, int val) {
            int tmp = val;
            if (map.containsKey(key)) val = val - map.get(key);
            map.put(key, tmp);
            Trie trie = root;
            for (char c : key.toCharArray()) {
                if (trie.children[c - 'a'] == null) {
                    trie.children[c - 'a'] = new Trie();
                }
                trie = trie.children[c - 'a'];
                trie.sum += val;
            }
        }

        public int sum(String prefix) {
            Trie trie = root;
            for (char c : prefix.toCharArray()) {
                if (trie.children[c - 'a'] == null) {
                    return 0;
                }
                trie = trie.children[c - 'a'];
            }
            return trie.sum;
        }
    }


    public static void main(String[] args) {
        MapSum test = new MapSum();
        test.insert("apple", 3);
        System.out.println(test.sum("ap"));
        test.insert("apple", 5);
        System.out.println(test.sum("ap"));
        test.insert("apple", 1);
        System.out.println(test.sum("ap"));
        test.insert("apple", 4);
        System.out.println(test.sum("ap"));


    }
}
