import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/9/26
 */
public class lc907 {
    public int sumSubarrayMins(int[] arr) {
        long sum = 0;
        long mod = 1_000_000_007;
        int[] nArr = new int[arr.length + 2];
        for (int i = 0; i < arr.length; ++i) {
            nArr[i + 1] = arr[i];
        }
        arr = nArr;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < arr.length; ++i) {
            while (!deque.isEmpty() && arr[deque.peekLast()] > arr[i]) {
                int last = deque.pollLast();
                sum += arr[last] * (long) ((i - last) * (last - deque.peekLast()));
                sum %= mod;
            }
            deque.addLast(i);
        }

        return (int) sum;
    }
}
