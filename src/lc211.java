import template.trie;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/11/20
 */
public class lc211 {
    class WordDictionary {
        public class Trie {
            boolean isWord = false;
            Trie[] children = new Trie[26];
        }

        Trie root = new Trie();

        /**
         * Initialize your data structure here.
         */
        public WordDictionary() {

        }

        /**
         * Adds a word into the data structure.
         */
        public void addWord(String word) {
            Trie trie = root;
            for (char c : word.toCharArray()) {
                if (trie.children[c - 'a'] == null) {
                    trie.children[c - 'a'] = new Trie();
                }
                trie = trie.children[c - 'a'];
            }
            trie.isWord = true;
        }

        /**
         * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
         */
        public boolean search(String word) {
            return searchDFS(root, word.toCharArray(), 0);
        }


        public boolean searchDFS(Trie trie, char[] c, int index) {
            if (index == c.length) {
                if (trie.isWord) return true;
                else return false;
            }

            char now = c[index];
            if (now == '.') {
                for (int i = 0; i < 26; ++i) {
                    if (trie.children[i] != null) {
                        if (searchDFS(trie.children[i], c, index + 1)) return true;
                    }
                }
                return false;
            }

            if (trie.children[now - 'a'] != null)
                if (searchDFS(trie.children[now - 'a'], c, index + 1)) return true;

            return false;
        }
    }
}
