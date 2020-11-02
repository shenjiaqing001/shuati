package Akuna;

import template.trie;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/11/2
 */
class Trie {
    int last = 0;
    Trie[] children = new Trie[2];
}


public class BinaryAutocomplete {
    public static List<Integer> autocomplete(List<String> command) {
        // Write your code here
        Trie root = new Trie();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < command.size(); ++i) {
            res.add(update(root, command.get(i), i + 1));
        }
        return res;
    }

    public static int update(Trie root, String command, int index) {
        int last = root.last;
        for (char c : command.toCharArray()) {
            if (root.children[c - '0'] != null) {
                root = root.children[c - '0'];
                last = root.last;
                root.last = index;
            } else {
                root.children[c - '0'] = new Trie();
                root = root.children[c - '0'];
                root.last = index;
            }
        }
        if (last == 0) {
            return index - 1;
        }
        return last;
    }

}
