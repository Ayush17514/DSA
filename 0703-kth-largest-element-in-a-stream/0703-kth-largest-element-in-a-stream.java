import java.util.PriorityQueue;

class KthLargest {

    private PriorityQueue<Integer> pq;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>();

        for (int num : nums) {
            add(num);          // reuse add()
        }
    }

    public int add(int val) {

        if (pq.size() < k) {
            pq.offer(val);
        }
        else if (val > pq.peek()) {
            pq.poll();
            pq.offer(val);
        }

        return pq.peek();
    }
}