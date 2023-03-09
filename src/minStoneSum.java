import java.util.Comparator;
import java.util.PriorityQueue;
/*
* You are given a 0-indexed integer array piles, where piles[i] represents the number of stones in the ith pile, and an integer k. You should apply the following operation exactly k times:

Choose any piles[i] and remove floor(piles[i] / 2) stones from it.
Notice that you can apply the operation on the same pile more than once.

Return the minimum possible total number of stones remaining after applying the k operations.

floor(x) is the greatest integer that is smaller than or equal to x (i.e., rounds x down).
* */
class minStoneSumSolution {

    // return the minimum number of total stones remaining after applying k operations
    // getting the max each time would be the best
    // sounds like a heap to me
    public static int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        int Sum = 0;
        for (int pile: piles) {
            Sum += pile;
            heap.add(pile);
        }
        int steps =0;
        double quotient =0;
        for (int i = 0; i < k; i++) {
            quotient = heap.remove();
            Sum -= quotient;
            quotient = Math.round(quotient/2);
            Sum +=quotient;
            heap.add((int)quotient);
        }
        return Sum;

    }
    public static void main(String[] args) {
        int[] piles1 = new int[]{5,4,9};
        System.out.println("Expected: 12, Actual: "+minStoneSum(piles1, 2));
        int[] piles2 = new int[]{4,3,6,7};
        System.out.println("Expected: 12, Actual: "+minStoneSum(piles2, 3));
    }
}