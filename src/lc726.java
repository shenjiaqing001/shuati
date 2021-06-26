import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/6/26
 */
public class lc726 {
    public void add(Map<String, Integer> lastMap, String atom, int count, boolean flag) {
        if (count == 0) count = 1;
        if (flag) {
            for (String key : lastMap.keySet()) {
                lastMap.put(key, lastMap.get(key) * count);
            }
        } else {
            lastMap.put(atom, lastMap.getOrDefault(atom, 0) + count);
        }
    }

    public void mergeLastTwo(Stack<Map<String, Integer>> stack) {
        Map<String, Integer> one = stack.pop();
        Map<String, Integer> two = stack.pop();
        for (String key : one.keySet()) {
            two.put(key, two.getOrDefault(key, 0) + one.get(key));
        }
        stack.add(two);
    }

    public String countOfAtoms(String formula) {
        Stack<Map<String, Integer>> stack = new Stack<>();
        int count = 0;
        String atom = "";
        Map<String, Integer> map = new HashMap<>();
        stack.push(map);
        boolean flag = false;
        boolean mergeLastTwo = false;
        for (char c : (formula + "A").toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                Map<String, Integer> lastMap = stack.pop();

                add(lastMap, atom, count, flag);
                stack.add(lastMap);
                if (mergeLastTwo) mergeLastTwo(stack);
                mergeLastTwo = false;
                flag = false;

                atom = "" + c;
                count = 0;
            } else if (c >= 'a' && c <= 'z') {
                atom += c;
            } else if (c >= '0' && c <= '9') {
                count = count * 10 + c - '0';
            } else if (c == '(') {
                Map<String, Integer> lastMap = stack.pop();
                add(lastMap, atom, count, flag);
                stack.add(lastMap);
                if (mergeLastTwo) mergeLastTwo(stack);
                mergeLastTwo = false;
                flag = false;
                atom = "";
                count = 0;
                Map<String, Integer> tmp = new HashMap<>();
                stack.add(tmp);
            } else if (c == ')') {
                Map<String, Integer> lastMap = stack.pop();
                add(lastMap, atom, count, flag);
                stack.add(lastMap);
                if (mergeLastTwo) mergeLastTwo(stack);
                mergeLastTwo = true;
                flag = true;
                atom = "";
                count = 0;
            }
        }

        Map<String, Integer> finalMap = new HashMap<>();
        while (!stack.isEmpty()) {
            Map<String, Integer> tmp = stack.pop();
            for (String key : tmp.keySet()) {
                finalMap.put(key, finalMap.getOrDefault(key, 0) + tmp.get(key));
            }
        }

        List<String> atomList = new ArrayList<>();
        for (String key : finalMap.keySet()) {
            atomList.add(key);
        }
        atomList.sort((o1, o2) -> o1.compareTo(o2));
        String res = "";
        for (String key : atomList) {
            if (key != "") {
                if (finalMap.get(key) == 1) {
                    res += key;
                } else {
                    res += key + finalMap.get(key);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        lc726 test = new lc726();
        System.out.println(test.countOfAtoms("Mg(OH)2"));
    }
}
