package algorithm_part1.priorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInanArr {
    public static void main(String[] args) {
        int num[] = {1, 3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;

        int kthLargest = findKthLargest(num, k);
        System.out.println("kthLargest = " + kthLargest);

    }

    public static int findKthLargest(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (Integer a : nums) {
            pq.add(a);
        }

        for (int i = 1; i < k; i++) {
            pq.poll();
        }

        return pq.poll();
    }
}