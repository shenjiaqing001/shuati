package LeetCodeContest.Fall2022;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/24/22
 */
public class lc2 {
    public int transportationHub(int[][] path) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Set<Integer> allNodes = new HashSet<>();
        Set<Integer> noSet = new HashSet<>();
        for (int[] p : path) {
            allNodes.add(p[0]);
            allNodes.add(p[1]);
            noSet.add(p[0]);
            map.putIfAbsent(p[1], new HashSet<>());
            map.get(p[1]).add(p[0]);
        }
        for (int node : allNodes) {
            if (noSet.contains(node)) continue;
            if (!map.containsKey(node)) continue;
            if (map.get(node).size() == allNodes.size() - 1) return node;
        }
        return -1;
    }
}
