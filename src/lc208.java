import javax.swing.table.TableRowSorter;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/5/20
 */
public class lc208 {
    Trie trie = new Trie();

    public class TrieNode {
        TrieNode[] children;
        boolean real = false;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }

    public class Trie {
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
            for (int i = 0; i < word.length(); ++i) {
                if (tmp.children[word.charAt(i) - 'a'] == null) {
                    tmp.children[word.charAt(i) - 'a'] = new TrieNode();
                }
                tmp = tmp.children[word.charAt(i) - 'a'];
            }
            tmp.real = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TrieNode tmp = root;
            for (int i = 0; i < word.length(); ++i) {
                if (tmp.children[word.charAt(i) - 'a'] == null)
                    return false;
                tmp = tmp.children[word.charAt(i) - 'a'];
            }
            if (tmp.real == false) return false;
            return true;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TrieNode tmp = root;
            for (int i = 0; i < prefix.length(); ++i) {
                if (tmp.children[prefix.charAt(i) - 'a'] == null)
                    return false;
                tmp = tmp.children[prefix.charAt(i) - 'a'];
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
