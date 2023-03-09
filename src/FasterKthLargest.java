import java.util.Comparator;
import java.util.PriorityQueue;

class KthLargest {

    public PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    public PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    public int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
       for (int num: nums) {
           maxHeap.add(num);
       }
        if (nums.length == 0) {
            return;
        }
        if (k > nums.length) {
            while (!maxHeap.isEmpty()) {
                minHeap.add(maxHeap.remove());
            }
            return;
        }


       while (minHeap.size() < k) {

           minHeap.add(maxHeap.remove());
       }

    }


    public int add(int val) {

        // account for nothing being in the heap??
        if (minHeap.isEmpty() || minHeap.size() < k) {
            minHeap.add(val);
            return minHeap.peek();
        }
        if (val >= minHeap.peek()) {
            minHeap.add(val);
            maxHeap.add(minHeap.remove());
            return minHeap.peek();
        }
        maxHeap.add(val);
        return minHeap.peek();

    }
    public static void main(String[] args) {
        int[] numbers1 = new int[]{4,5,8,2};
        KthLargest AK = new KthLargest(3, numbers1);
        System.out.println("Expected: 4, actual: "+AK.add(3));
        System.out.println("Expected: 5, actual: "+AK.add(5));
        System.out.println("Expected: 5, actual: "+AK.add(10));
        System.out.println("Expected: 8, actual: "+AK.add(9));
        System.out.println("Expected: 8, actual: "+AK.add(4));


        int[] numbers2 = new int[]{};
        KthLargest AK1 = new KthLargest(1, numbers2);
        System.out.println("Expected: -3, actual: "+AK1.add(-3));
        System.out.println("Expected: -2, actual: "+AK1.add(-2));
        System.out.println("Expected: -2, actual: "+AK1.add(-4));
        System.out.println("Expected: 0, actual: "+AK1.add(0));

       // [[1,[]],[-3],[-2],[-4],[0],[4]]

    }
}