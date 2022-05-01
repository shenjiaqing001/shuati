package WeeklyContest288;

import java.util.PriorityQueue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 4/9/22
 */
public class lc3 {
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : nums){
            pq.add(num);
        }
        while(k > 0){
            int num = pq.poll();
            pq.add(num + 1);
            k--;
        }

        if(pq.peek() == 0) return 0;
        else{
            long res = 1;
            long mod = 1_000_000_007;
            while(!pq.isEmpty()){
                res *= pq.poll();
                res %= mod;
            }
            return (int) res;
        }
    }
}
