package newAlgorithms.slidingWindow;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class N480SlidingWindowMedian {
    class Solution {

        PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder()); // maxHeap
        PriorityQueue<Integer> large = new PriorityQueue<>(); // minHeap
        Map<Integer, Integer> delayed = new HashMap<>();

        int k;
        int smallSize = 0, largeSize = 0;

        public double[] medianSlidingWindow(int[] nums, int k) {
            this.k = k;
            double[] res = new double[nums.length - k + 1];

            for (int i = 0; i < k; i++) add(nums[i]);

            res[0] = getMedian();

            for (int i = k; i < nums.length; i++) {
                add(nums[i]);
                remove(nums[i - k]);
                res[i - k + 1] = getMedian();
            }

            return res;
        }

        private void add(int num) {
            if (small.isEmpty() || num <= small.peek()) {
                small.offer(num);
                smallSize++;
            } else {
                large.offer(num);
                largeSize++;
            }
            balance();
        }

        private void remove(int num) {
            delayed.put(num, delayed.getOrDefault(num, 0) + 1);

            if (num <= small.peek()) {
                smallSize--;
                if (num == small.peek()) prune(small);
            } else {
                largeSize--;
                if (num == large.peek()) prune(large);
            }
            balance();
        }

        private void balance() {
            if (smallSize > largeSize + 1) {
                large.offer(small.poll());
                smallSize--;
                largeSize++;
                prune(small);
            } else if (smallSize < largeSize) {
                small.offer(large.poll());
                smallSize++;
                largeSize--;
                prune(large);
            }
        }

        private void prune(PriorityQueue<Integer> heap) {
            while (!heap.isEmpty()) {
                int num = heap.peek();
                if (delayed.containsKey(num)) {
                    delayed.put(num, delayed.get(num) - 1);
                    if (delayed.get(num) == 0) delayed.remove(num);
                    heap.poll();
                } else break;
            }
        }

        private double getMedian() {
            if (k % 2 == 1) return small.peek();
            return ((double) small.peek() + large.peek()) / 2.0;
        }
    }
}
