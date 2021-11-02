package WeeklyContest265;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/30
 */
public class lc2060 {
    Set<Integer>[][] sets = new Set[41][41];

    //"v375v736v443v897v633v527v781v121v317"
    //"475v899v753v784v438v415v431v216v968"
    public static void main(String[] args) {
        lc2060 test = new lc2060();
        test.possiblyEquals("x94", "x14");
    }

    public boolean possiblyEquals(String s1, String s2) {
        for (int i = 0; i <= 40; ++i) {
            for (int j = 0; j <= 40; ++j) {
                sets[i][j] = new HashSet<>();
            }
        }
        return check(s1.toCharArray(), s2.toCharArray(), 0, 0, 0);
    }

    public boolean isDigit(char c) {
        return c <= '9' && c >= '1';
    }

    // diff = s1 - s2
    public boolean check(char[] c1, char[] c2, int index1, int index2, int diff) {
        if (index1 == c1.length && index2 == c2.length) {
            return diff == 0;
        }
        if (sets[index1][index2].contains(diff)) return false;
        if (c1.length == index1) {
            if (diff <= 0) {

            } else if (!isDigit(c2[index2])) {
                if (check(c1, c2, index1, index2 + 1, diff - 1)) return true;
            } else {
                int num = c2[index2] - '0';
                if (check(c1, c2, index1, index2 + 1, diff - num)) return true;
                if (index2 + 1 < c2.length && isDigit(c2[index2 + 1])) {
                    num = 10 * num + c2[index2 + 1] - '0';
                    if (check(c1, c2, index1, index2 + 2, diff - num)) return true;
                    if (index2 + 2 < c2.length && isDigit(c2[index2 + 2])) {
                        num = 10 * num + c2[index2 + 2] - '0';
                        if (check(c1, c2, index1, index2 + 3, diff - num)) return true;
                    }
                }
            }
        } else if (c2.length == index2) {
            if (diff >= 0) {

            } else if (!isDigit(c1[index1])) {
                if (check(c1, c2, index1 + 1, index2, diff + 1)) return true;
            } else {
                int num = c1[index1] - '0';
                if (check(c1, c2, index1 + 1, index2, diff + num)) return true;
                if (index1 + 1 < c1.length && isDigit(c1[index1 + 1])) {
                    num = 10 * num + c1[index1 + 1] - '0';
                    if (check(c1, c2, index1 + 2, index2, diff + num)) return true;
                    if (index1 + 2 < c1.length && isDigit(c1[index1 + 2])) {
                        num = 10 * num + c1[index1 + 2] - '0';
                        if (check(c1, c2, index1 + 3, index2, diff + num)) return true;
                    }
                }
            }
        } else {
            if (diff == 0) {
                if (!isDigit(c1[index1]) && !isDigit(c2[index2])) {
                    if (c1[index1] != c2[index2]) {

                    } else {
                        if (check(c1, c2, index1 + 1, index2 + 1, diff)) return true;
                    }
                } else {
                    if (isDigit(c1[index1])) {
                        int num = c1[index1] - '0';
                        if (check(c1, c2, index1 + 1, index2, diff + num)) return true;
                        if (index1 + 1 < c1.length && isDigit(c1[index1 + 1])) {
                            num = 10 * num + c1[index1 + 1] - '0';
                            if (check(c1, c2, index1 + 2, index2, diff + num)) return true;
                            if (index1 + 2 < c1.length && isDigit(c1[index1 + 2])) {
                                num = 10 * num + c1[index1 + 2] - '0';
                                if (check(c1, c2, index1 + 3, index2, diff + num)) return true;
                            }
                        }
                    } else {
                        int num = c2[index2] - '0';
                        if (check(c1, c2, index1, index2 + 1, diff - num)) return true;
                        if (index2 + 1 < c2.length && isDigit(c2[index2 + 1])) {
                            num = 10 * num + c2[index2 + 1] - '0';
                            if (check(c1, c2, index1, index2 + 2, diff - num)) return true;
                            if (index2 + 2 < c2.length && isDigit(c2[index2 + 2])) {
                                num = 10 * num + c2[index2 + 2] - '0';
                                if (check(c1, c2, index1, index2 + 3, diff - num)) return true;
                            }
                        }
                    }
                }
            } else {
                if (diff > 0) {
                    if (!isDigit(c2[index2])) {
                        if (check(c1, c2, index1, index2 + 1, diff - 1)) return true;
                    } else {
                        int num = c2[index2] - '0';
                        if (check(c1, c2, index1, index2 + 1, diff - num)) return true;
                        if (index2 + 1 < c2.length && isDigit(c2[index2 + 1])) {
                            num = 10 * num + c2[index2 + 1] - '0';
                            if (check(c1, c2, index1, index2 + 2, diff - num)) return true;
                            if (index2 + 2 < c2.length && isDigit(c2[index2 + 2])) {
                                num = 10 * num + c2[index2 + 2] - '0';
                                if (check(c1, c2, index1, index2 + 3, diff - num)) return true;
                            }
                        }
                    }
                } else {
                    if (!isDigit(c1[index1])) {
                        if (check(c1, c2, index1 + 1, index2, diff + 1)) return true;
                    } else {
                        int num = c1[index1] - '0';
                        if (check(c1, c2, index1 + 1, index2, diff + num)) return true;
                        if (index1 + 1 < c1.length && isDigit(c1[index1 + 1])) {
                            num = 10 * num + c1[index1 + 1] - '0';
                            if (check(c1, c2, index1 + 2, index2, diff + num)) return true;
                            if (index1 + 2 < c1.length && isDigit(c1[index1 + 2])) {
                                num = 10 * num + c1[index1 + 2] - '0';
                                if (check(c1, c2, index1 + 3, index2, diff + num)) return true;
                            }
                        }
                    }
                }
            }
        }
        sets[index1][index2].add(diff);
        return false;
    }
}
