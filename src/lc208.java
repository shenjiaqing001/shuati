/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/5/20
 */
public class lc208 {
    Trie trie = new Trie();


    public class Trie {
        public class TrieNode {
            TrieNode[] children;
            boolean isWord = false;

            public TrieNode() {
                children = new TrieNode[26];
            }
        }

        TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new TrieNode();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TrieNode tmp = root;
            for (char c : word.toCharArray()) {
                if (tmp.children[c - 'a'] == null) {
                    tmp.children[c - 'a'] = new TrieNode();
                }
                tmp = tmp.children[c - 'a'];
            }
            tmp.isWord = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TrieNode tmp = root;
            for (char c : word.toCharArray()) {
                if (tmp.children[c - 'a'] == null)
                    return false;
                tmp = tmp.children[c - 'a'];
            }
            return tmp.isWord;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TrieNode tmp = root;
            for (char c : prefix.toCharArray()) {
                if (tmp.children[c - 'a'] == null) {
                    return false;
                }
                tmp = tmp.children[c - 'a'];
            }
            return true;
        }
    }

    public static void main(String[] args) {
        lc208 t = new lc208();
        t.trie.insert("apple");
        System.out.println(t.trie.search("apple"));
        System.out.println(t.trie.search("app"));
        System.out.println(t.trie.startsWith("app"));
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
}
