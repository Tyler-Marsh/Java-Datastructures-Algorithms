import java.util.Comparator;
import java.util.PriorityQueue;

class MedianFinder {

// attributes
    // why don't I have to provide the new PriorityQueue<> a type
        private PriorityQueue<Integer> lower = new PriorityQueue<>();
        private PriorityQueue<Integer> higher = new PriorityQueue<>(Comparator.reverseOrder());


    // adds a number
    public void addNum(int num) {
        // because it has to be ordered they can't add a number smaller
        // I was thinking about it in a too complex way
        // really read the questions.
        // new number must be the biggest
    higher.add(num);
    // minHeaps biggest number must be maxHeap's smallest
    lower.add(higher.remove());
      if (lower.size() > higher.size()) {
        higher.add(lower.remove());
      }
    }

    public double findMedian() {
       if (higher.size() > lower.size()) {
           return higher.peek();
       }
       return (lower.peek() + higher.peek()) / 2.0;

    }
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(4);

    }
}