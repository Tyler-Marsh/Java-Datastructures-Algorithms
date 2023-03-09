import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
/*
* You are given an array of integers stones where stones[i] is the weight of the
ith stone. On each turn, we choose the heaviest two stones and smash them together.
* Suppose the heaviest two stones have weights x and y with x <= y. If x == y, then both stones are destroyed.
* If x != y, then x is destroyed and y loses x weight. Return the weight of the last remaining stone, or 0 if
* there are no stones left.
* */
class Solution {

    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone: stones) {
            heap.add(stone);
        }

        while (heap.size() > 1) {
            int first = heap.remove();
            int second = heap.remove();
            if (first != second) {
                heap.add(first - second);
            }
        }

        return heap.isEmpty() ? 0: heap.remove();
    }

    public static void main(String[] args) {
       // ArrayList<Integer> stones = new ArrayList<Integer>{2, 7, 4, 1, 8, 1};
        int[] stones = new int[]{2, 7, 4, 1, 8, 1};
        // This worked...


        System.out.println("Expected: 1, Actual: " +lastStoneWeight(stones));
        System.out.println("Expected: 1, Actual: " + Integer.toString(lastStoneWeight(stones)));
        // System.out.println((String)lastStoneWeight(stones));

    }
}