package LeetCodeContest.Fall2021.个人赛;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/9/11
 */
public class lc5 {
    int[][][][] memo = new int[21][21][21][21];
    int[][] dirs = new int[4][21];
    Set<Integer> set = new HashSet<>();

    public boolean checkState(int i) {
        int nDir = i % 5;
        i /= 5;
        int wDir = i % 5;
        i /= 5;
        int sDir = i % 5;
        i /= 5;
        int eDir = i % 5;
        if (eDir == 1 || sDir == 2 || wDir == 3 || nDir == 4) return false;

        if (nDir != 0 && wDir != 0 && nDir == wDir) return false;
        if (nDir != 0 && sDir != 0 && nDir == sDir) return false;
        if (nDir != 0 && eDir != 0 && nDir == eDir) return false;
        if (wDir != 0 && sDir != 0 && wDir == sDir) return false;
        if (wDir != 0 && eDir != 0 && wDir == eDir) return false;
        if (sDir != 0 && eDir != 0 && sDir == eDir) return false;

        if (eDir == 3 && (nDir == 2 || sDir == 4 || nDir == 1 || wDir == 4)) return false;
        if (sDir == 4 && (eDir == 3 || eDir == 2 || wDir == 1 || nDir == 1)) return false;
        if (wDir == 1 && (nDir == 2 || sDir == 4 || eDir == 2 || sDir == 3)) return false;
        if (nDir == 2 && (eDir == 3 || wDir == 1 || sDir == 3 || wDir == 4)) return false;
        return true;
    }

    public int trafficCommand(String[] directions) {
        for (int i = 0; i < 4; ++i) {
            char[] c = directions[i].toCharArray();
            for (int j = 0; j < c.length; ++j) {
                if (c[j] == 'E') dirs[i][j] = 1;
                if (c[j] == 'S') dirs[i][j] = 2;
                if (c[j] == 'W') dirs[i][j] = 3;
                if (c[j] == 'N') dirs[i][j] = 4;
            }
        }

        for (int i = 0; i < 625; ++i) {
            if (checkState(i)) set.add(i);
        }
        // System.out.println(set.size());
        // System.out.println(set);


        dfs(0, 0, 0, 0);

        return memo[0][0][0][0];
    }

    public int dfs(int i1, int i2, int i3, int i4) {
        if (memo[i1][i2][i3][i4] != 0) return memo[i1][i2][i3][i4];

        int d1 = dirs[0][i1];
        int d2 = dirs[1][i2];
        int d3 = dirs[2][i3];
        int d4 = dirs[3][i4];
//        System.out.println(d1 + " " + d2 + " " + d3 + " " + d4);

        if (d1 == 0 && d2 == 0 && d3 == 0 && d4 == 0) {
            return 0;
        }
        int min = 1000;
        for (int i = 1; i < 625; ++i) {
            if (!set.contains(i)) continue;
            int dir = i;
            int nDir = dir % 5;
            dir /= 5;
            int wDir = dir % 5;
            dir /= 5;
            int sDir = dir % 5;
            dir /= 5;
            int eDir = dir % 5;
//            System.out.println(eDir + " " + sDir + " " + wDir + " " + nDir);
            if (d1 != 0 && eDir != 0 && eDir != d1) continue;
            if (d2 != 0 && sDir != 0 && sDir != d2) continue;
            if (d3 != 0 && wDir != 0 && wDir != d3) continue;
            if (d4 != 0 && nDir != 0 && nDir != d4) continue;
            if (d1 == 0 && eDir != 0) continue;
            if (d2 == 0 && sDir != 0) continue;
            if (d3 == 0 && wDir != 0) continue;
            if (d4 == 0 && nDir != 0) continue;

            min = Math.min(min, dfs(eDir == 0 ? i1 : i1 + 1, sDir == 0 ? i2 : i2 + 1,
                    wDir == 0 ? i3 : i3 + 1, nDir == 0 ? i4 : i4 + 1) + 1);
        }
        memo[i1][i2][i3][i4] = min;
        return min;
    }


}
