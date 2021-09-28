package LeetCodeContest.Fall2021.团队赛;

import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/9/25
 */
public class lc5 {
    int[][] dirs =
            new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    public String gobang(int[][] pieces) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] piece : pieces) {
            map.putIfAbsent(piece[0], new HashMap<>());
            map.get(piece[0]).put(piece[1], piece[2]);
        }
        System.out.println(howManyWins(map, 0).size());
        if (howManyWins(map, 0).size() > 0) return "Black";
        Set<String> whiteWins = howManyWins(map, 1);
        if (whiteWins.size() > 0) {
            if (whiteWins.size() > 1) return "White";
            int[] onlyPosition = new int[2];
            for (String s : whiteWins) {
                onlyPosition[0] = Integer.parseInt(s.split(";")[0]);
                onlyPosition[1] = Integer.parseInt(s.split(";")[1]);
            }

            if (check(map, onlyPosition[0], onlyPosition[1]).size() > 1) return "Black";
            else return "None";
        }

        Set<String> emptyPositions = threeInFive(map);
        for (String p : emptyPositions) {
            int p0 = Integer.parseInt(p.split(";")[0]);
            int p1 = Integer.parseInt(p.split(";")[1]);
            if (check(map, p0, p1).size() > 1) return "Black";
        }
        return "None";
    }

    public Set<String> threeInFive(Map<Integer, Map<Integer, Integer>> map) {
        Set<String> set = new HashSet<>();
        for (Integer x : map.keySet()) {
            for (Integer y : map.get(x).keySet()) {
                if (map.get(x).get(y) == 0) {

                    for (int[] dir : dirs) {
                        List<Integer> left = new ArrayList<>();
                        int step = 1;
                        while (step <= 4) {
                            int nx = x + dir[0] * step;
                            int ny = y + dir[1] * step;
                            if (!map.containsKey(nx)) {
                                if (left.size() > 1) break;
                                left.add(step);
                            } else if (!map.get(nx).containsKey(ny)) {
                                if (left.size() > 1) break;
                                left.add(step);
                            } else if (map.get(nx).get(ny) != 0) break;
                            step++;
                        }
                        if (step != 5) continue;
                        for (int l : left) {
                            set.add((x + dir[0] * l) + ";" + (y + dir[1] * l));
                        }
                    }
                }
            }
        }
        return set;
    }

    public Set<String> check(Map<Integer, Map<Integer, Integer>> map, int x, int y) {
        Set<String> set = new HashSet<>();
        for (int[] dir : dirs) {
            for (int i = 0; i < 5; ++i) {
                int j = 0;
                int left = -10;
                for (j = 0; j < 5; ++j) {
                    if (i == j) continue;
                    int xPos = x + dir[0] * (i - j);
                    int yPos = y + dir[1] * (i - j);
                    if (!map.containsKey(xPos)) {
                        if (left != -10) break;
                        left = i - j;
                    } else if (!map.get(xPos).containsKey(yPos)) {
                        if (left != -10) break;
                        left = i - j;
                    } else if (map.get(xPos).get(yPos) != 0) break;
                }
                if (j != 5) continue;
                if (left != -10) {
                    String s = (x + dir[0] * left) + ";" + (y + dir[1] * left);
                    set.add(s);
                }
            }
        }
        return set;
    }

    public Set<String> howManyWins(Map<Integer, Map<Integer, Integer>> map, int color) {
        Set<String> set = new HashSet<>();
        for (Integer x : map.keySet()) {
            for (Integer y : map.get(x).keySet()) {
                if (map.get(x).get(y) == color) {
                    for (int[] dir : dirs) {
                        int step = 1;
                        int left = 0;
                        while (step <= 4) {
                            int nx = x + dir[0] * step;
                            int ny = y + dir[1] * step;
                            if (!map.containsKey(nx)) {
                                if (left != 0) break;
                                left = step;
                            } else if (!map.get(nx).containsKey(ny)) {
                                if (left != 0) break;
                                left = step;
                            } else if (map.get(nx).get(ny) != color) break;
                            step++;
                        }
                        if (step != 5) continue;
                        String s = (x + dir[0] * left) + ";" + (y + dir[1] * left);
                        set.add(s);
                    }
                }
            }
        }
        return set;
    }
}
