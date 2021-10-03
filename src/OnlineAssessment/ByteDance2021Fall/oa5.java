package OnlineAssessment.ByteDance2021Fall;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/2
 */
public class oa5 {

    public static void main(String[] args) {
        oa5 test = new oa5();
        System.out.println(test.isATree("(B,D) (D,E) (A,B) (C,F) (E,G) (A,C)"));
    }

    public String isATree(String str) {
        String[] pairs = str.split(" ");
        if (pairs.length == 0) return "()";
        Map<Character, Set<Character>> childrenMap = new HashMap<>();
        Map<Character, Character> parentMap = new HashMap<>();
        int[] outCount = new int[26];
        for (String pair : pairs) {
            if (pair.length() != 5) return "E5";
            if (pair.charAt(0) != '(') return "E5";
            if (pair.charAt(2) != ',') return "E5";
            if (pair.charAt(4) != ')') return "E5";
            if (pair.charAt(1) < 'A' || pair.charAt(1) > 'Z' || pair.charAt(3) < 'A' ||
                    pair.charAt(3) > 'Z')
                return "E5";

            Character parent = pair.charAt(1);
            Character child = pair.charAt(3);
            childrenMap.putIfAbsent(parent, new HashSet<>());
            if (childrenMap.get(parent).contains(child)) return "E2";
            childrenMap.get(parent).add(child);
            if (childrenMap.get(parent).size() > 2) return "E1";
            if (parentMap.containsKey(child)) return "E3";
            parentMap.put(child, parent);
            outCount[parent - 'A']++;
            outCount[child - 'A']--;
        }
        int root = -1;
        for (int i = 0; i < 26; ++i) {
            if (outCount[i] > 0) {
                if (root != -1) return "E4";
                root = i;
            }
        }
        if (root == -1) return "E3";
        return buildTree((char) (root + 'A'), childrenMap);
    }

    public String buildTree(Character root, Map<Character, Set<Character>> childrenMap) {
        String res = "(";
        res += root;
        if (childrenMap.containsKey(root)) {
            Set<Character> children = childrenMap.get(root);
            // todo: 把 set 里面的child， 排序一下， ED变成DE。  java 不好做。
            for (Character child : children) {
                res += buildTree(child, childrenMap);
            }
        }
        res += ")";
        return res;
    }

}
