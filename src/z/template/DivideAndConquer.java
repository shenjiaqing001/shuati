package z.template;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/27/22
 */
public class DivideAndConquer {
    public class Node {
        long x;
        long y;

        Node(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    public long distance(Node a, Node b) {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
    }

    public long minDistance(Node[] nodes, int left, int right) {
        if (left >= right) return Long.MAX_VALUE;
        if (right - left == 1) {
            return distance(nodes[left], nodes[right]);
        }
        if (right - left == 2) {
            return Math.min(Math.min(distance(nodes[left], nodes[right]),
                            distance(nodes[left], nodes[left + 1])),
                    distance(nodes[left + 1], nodes[right]));
        }
        int mid = left + (right - left) / 2;
        long leftMin = minDistance(nodes, left, mid);
        long rightMin = minDistance(nodes, mid + 1, right);
        long min = Math.min(leftMin, rightMin);
        List<Node> midNodes = new ArrayList<>();
        for (int i = left; i <= right; ++i) {
            if ((nodes[mid].x - nodes[i].x) * (nodes[mid].x - nodes[i].x) <= min) {
                midNodes.add(nodes[i]);
            }
        }
        midNodes.sort(Comparator.comparingLong(n -> n.y));
        for (int i = 0; i < midNodes.size(); ++i) {
            for (int j = i + 1; j < midNodes.size(); ++j) {
                long yDistance = midNodes.get(i).y - midNodes.get(j).y;
                if (yDistance * yDistance >= min) break;
                long dTmp = distance(midNodes.get(i), midNodes.get(j));
                min = Math.min(min, dTmp);
            }
        }
        return min;
    }

    public long solve(Node[] nodes) {
        Arrays.sort(nodes, Comparator.comparingLong(n -> n.x));
        for (int i = 1; i < nodes.length; i++) {
            if (distance(nodes[i - 1], nodes[i]) == 0) return 0;
        }
        return minDistance(nodes, 0, nodes.length - 1);
    }

    public long start(int[][] list) {
        Node[] nodes = new Node[list.length];
        for (int i = 0; i < nodes.length; ++i) {
            nodes[i] = new Node(list[i][0], list[i][1]);
        }
        return solve(nodes);
    }

    public static void main(String[] args) {
        DivideAndConquer test = new DivideAndConquer();
        System.out.println(test.start(new int[][]{{-3, 2}, {-10, -100}, {-5, -7}, {0, 2}}));
    }
}
