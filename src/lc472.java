import java.util.LinkedList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/2
 */
public class lc472 {
    public class Trie {
        boolean isWord = false;
        Trie[] children = new Trie[26];
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Trie root = new Trie();
        for (String str : words) {
            Trie trie = root;
            for (char c : str.toCharArray()) {
                if (trie.children[c - 'a'] == null) {
                    trie.children[c - 'a'] = new Trie();
                }
                trie = trie.children[c - 'a'];
            }
            trie.isWord = true;
        }

        List<String> res = new LinkedList<>();

        for (String word : words) {
            int length = dfs(root, word);
            System.out.println(word + " " + length);
            if (length >= 2) {
                res.add(word);
            }
        }

        return res;
    }

    public int dfs(Trie root, String word) {
        if (word.equals("")) return 0;
        Trie tmp = root;
        int max = -1;
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            if (tmp.children[c - 'a'] != null)
                tmp = tmp.children[c - 'a'];
            else {
                break;
            }

            if (tmp.isWord) {
                max = Math.max(max, dfs(root, word.substring(i + 1)));
            }
        }
        if (max == -1) return -1;
        return max + 1;
    }

    public static void main(String[] args) {
        lc472 test = new lc472();
        test.findAllConcatenatedWordsInADict(
                new String[]{"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses",
                        "rat", "ratcatdogcat"});
    }

}
