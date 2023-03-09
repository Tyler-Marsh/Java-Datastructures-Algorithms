import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class KClosest1Solution {
    static public List<Integer> findClosestElements(int[] arr, int k, int x) {


        // > 0  n1 b4 n2
        // < 0 n2 b4 n1
        // 0 == same order
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> {
            if (Math.abs(n2 - x) == Math.abs(n1 - x)) {
                return n2 - n1;
            }
            return Math.abs(n2 - x) - Math.abs(n1 - x);
        });

        for (int num: arr) {
            heap.add(num);
            if (heap.size() > k) {
                heap.remove();
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ans.add(heap.remove());
        }

        Collections.sort(ans);
        return ans;
    }

    public static void main(String[] args) {

        int[] arr1 = new int[]{1,2,3,4,5};
        // 1 2 4 5

        // 1 ,2 ,3 ,4
        System.out.println(findClosestElements(arr1, 4, 3));
    }
}