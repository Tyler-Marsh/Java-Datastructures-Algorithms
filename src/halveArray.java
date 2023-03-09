import java.util.Comparator;
import java.util.PriorityQueue;

/*
* You are given an array nums of positive integers. In one operation,
*  you can choose any number from nums and reduce it to exactly half the number.
*  (Note that you may choose this reduced number in future operations.)
Return the minimum number of operations to reduce the sum of nums by at least half.
* */
// Halving the greatest number each time would be the fastest way to make sure you get half the sum
class halveArraySolution {

    public int halveArray(int[] nums) {
        int steps = 0;
        int sum = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num: nums) {
            sum += num;
            heap.add(num);
        }
        int half = sum/2;
        int popped = 0;
        while (sum > half) {
            popped = heap.remove();
            sum -= popped;
            popped = popped/2;
            sum += popped;
            heap.add(popped);
            steps++;
        }
        return steps;

    }
    public static void main(String[] args) {
        int[] nums1 = new int[]{5,19,8,1};
        int [] nums2 = new int[]{3,8,20};
        // or make the method static
        halveArraySolution solution = new halveArraySolution();
        System.out.println("Expected: 3, actual: " + Integer.toString(solution.halveArray(nums1)));
        System.out.println("Expected: 3, actual: " + Integer.toString(solution.halveArray(nums2)));

    }
}