import java.util.*;
// Given an array of strings words and an integer k, return the k most frequent strings.
//
//Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.

class topKFrequentSolution {

    static public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> counts = new HashMap<>();
        for (String word: words) {
           counts.put(word, counts.getOrDefault(word, 0) + 1);
        }
        // min heap?

        PriorityQueue<String> heap = new PriorityQueue<>((word1, word2) -> {

            if (counts.get(word1) == counts.get(word2)) {
                //
                int comp = word2.compareTo(word1);
                return comp;
            }
            return counts.get(word1) - counts.get(word2);
        }
        );
        //
        for (String word: counts.keySet()) {
            heap.add(word);
            if (heap.size() > k) {
                heap.remove();
            }
        }

        List<String> ans = new ArrayList<String>();
        for (int i = 0; i < k; i++) {

            ans.add(heap.remove());
        }
        Collections.reverse(ans);
        return ans;
    }
// Sort the words with the same frequency by their lexicographical order.
    public static void main(String[] args) {
        String[] words1 = new String[]{"i", "love", "leetcode", "i", "love", "coding"};
        System.out.println(topKFrequent(words1, 2));
        String[] words2 = new String[]{"the","day","is","sunny","the","the","the","sunny","is","is"};
        System.out.println(topKFrequent(words2, 4));
    }
}