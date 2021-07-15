

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/9
 */
public class lc1698 {

    public class Trie {
        boolean isWord = false;
        Trie[] children = new Trie[26];
    }

    public int countDistinct2(String s) {
        Trie root = new Trie();
        int res = 0;
        for (int i = 0; i < s.length(); ++i) {
            Trie trie = root;
            for (int j = i; j < s.length(); ++j) {
                if (trie.children[s.charAt(j) - 'a'] == null) {
                    trie.children[s.charAt(j) - 'a'] = new Trie();
                }
                trie = trie.children[s.charAt(j) - 'a'];
                if (!trie.isWord) {
                    trie.isWord = true;
                    res++;
                }
            }
        }
        return res;
    }
}
