class Solution {

    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {

        
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> (b[1] - a[1]));

        
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[0] - b[0]));



        
        for (int i = 0; i < Capital.length; i++) {

            minHeap.offer(new int[]{Capital[i], Profits[i]});

        }

        
        for (int i = 0; i < k; i++) {

            
            
            while (!minHeap.isEmpty() && W >= minHeap.peek()[0]) {

                maxHeap.offer(minHeap.poll());

            }

            
            if (maxHeap.isEmpty()) {

                return W;

            }

            
            W += maxHeap.poll()[1];

        }



        return W;

    }

}