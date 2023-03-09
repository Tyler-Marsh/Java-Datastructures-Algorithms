import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class topKFrequentSolution1 {

    static public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num: nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        // Lambda Expression is like an anonymous function you can use/pass as a value
        // the Lambda Expression determines which value should be next to be peeked
        // n1 will be the smaller one in lambda expression
        // how should I know that n1 will be the less occuring number?
        // least frequent element is removed first???

        // each time you fetch or seek an element from the PriorityQueue
        //

        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2)-> counts.get(n1) - counts.get(n2));
        for (int num: counts.keySet()) {
            heap.add(num);
            if (heap.size() > k) {
                heap.remove();
            }
        }

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = heap.remove();
        }
        return ans;
    }
    public static void main(String[] args) {

        int[] nums = new int[]{1,1,1,2,2,3};
        System.out.println(topKFrequent(nums,2));
    }
}