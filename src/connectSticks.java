import java.util.PriorityQueue;
/*You have some number of sticks with positive integer lengths. These lengths are given as an array sticks, where sticks[i] is the length of the ith stick.

You can connect any two sticks of lengths x and y into one stick by paying a cost of x + y. You must connect all the sticks until there is only one stick remaining.

Return the minimum cost of connecting all the given sticks into one stick in this way.

* */
class connectSticksSolution {

    public static int connectSticks(int[] sticks) {
        if (sticks.length <= 1) {
            return 0;
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int stick: sticks) {
            heap.add(stick);
        }
        int cost = 0;
        int total =0;
        while (heap.size() > 1) {
            cost = (heap.remove() + heap.remove());
            heap.add(cost);
            total+= cost;
        }
        return  total;

    }
    public static void main(String[] args) {

        int[] sticks1 = new int[]{2,4,3};
        System.out.println("Expected: 14, Actual: " + connectSticks(sticks1));
    }
}