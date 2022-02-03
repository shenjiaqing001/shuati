package mock.day0130;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 1/30/22
 */
public class canku2 {

    /*
    保持递增: 给你一个字符串，里面包含小写字母和问号。你可以将问号替换为任意的小写字母或者直接删去。问操作后字符串里最长的、以a开头的连续递增子串的长度是多少。
    */

    public int dizeng(String s) {
        int max = 0;
        int count = 0;
        int strict = 0;
        boolean flag = false;
        for (char c : s.toCharArray()) {
            if (c == 'a') {
                count = 0;
                strict = 1;
                flag = true;
            } else {
                if (!flag) {
                    if (c == '?') {
                        flag = true;
                        count = 1;
                        strict = 0;
                    }
                } else {
                    if (c == '?') {
                        count++;
                    } else {
                        if (strict + count >= c - 'a') {
                            strict = c - 'a' + 1;
                            count = 0;
                        } else {
                            flag = false;
                        }
                    }
                }
            }
            max = Math.max(max, count + strict);
        }
        return max;
    }


    public int dizeng2(String s) {
        int max = 0;
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == 'a') {
                stack.clear();
                stack.add(c);
            } else if (c == '?') {
                stack.add('?');
            } else {
                if (!stack.isEmpty()) {
                    if (stack.size() < c - 'a') {
                        stack.clear();
                    } else {
                        while (stack.size() > c - 'a' && stack.peekLast() == '?') {
                            stack.pollLast();
                        }
                        if (stack.size() > c - 'a') {
                            stack.clear();
                        } else {
                            stack.add(c);
                        }
                    }
                }
            }
            max = Math.max(max, stack.size());
        }
        return Math.min(max, 26);
    }

    public static void main(String[] args) {
        canku2 test = new canku2();
        System.out.println(test.dizeng("a???bcd"));
        System.out.println(test.dizeng("???bcd"));
        System.out.println(test.dizeng("a?b??cd??"));
        System.out.println(test.dizeng("???????"));
        System.out.println(test.dizeng("a?bb??bcd?e??f"));


        System.out.println(test.dizeng2("a???bcd"));
        System.out.println(test.dizeng2("???bcd"));
        System.out.println(test.dizeng2("a?b??cd??"));
        System.out.println(test.dizeng2("???????"));
        System.out.println(test.dizeng2("a?bb??bcd?e??f"));

    }

}
