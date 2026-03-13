class Solution {

    private static final double EPS = 1e-7;

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        int maxWorkerTimes = 0;
        for (int t : workerTimes) {
            maxWorkerTimes = Math.max(maxWorkerTimes, t);
        }

        long l = 1;
        long r =
            ((long) maxWorkerTimes * mountainHeight * (mountainHeight + 1)) / 2;
        long ans = 0;

        while (l <= r) {
            long mid = (l + r) / 2;
            long cnt = 0;
            for (int t : workerTimes) {
                long work = mid / t;
                // find the largest k such that 1+2+...+k <= work
                long k = (long) ((-1.0 + Math.sqrt(1 + work * 8)) / 2 + EPS);
                cnt += k;
            }

            if (cnt >= mountainHeight) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }
}

// Priority Queue Solution
// import java.util.PriorityQueue;

// class Solution {
//     public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
//         // Priority queue to store pairs in the form of (total_time, (original_time, iteration))
//         PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));

//         // Initialize the priority queue with worker times
//         for (int time : workerTimes) {
//             pq.offer(new long[]{time, time, 1}); // (current time, original time, iteration count)
//         }

//         long ans = 0;

//         // Process each height increment of the mountain
//         for (int i = 0; i < mountainHeight; i++) {
//             long[] top = pq.poll();
//             long currentTime = top[0];
//             long originalTime = top[1];
//             long iteration = top[2];

//             ans = currentTime;

//             // Push the next time for this worker back into the priority queue
//             pq.offer(new long[]{currentTime + originalTime * (iteration + 1), originalTime, iteration + 1});
//         }

//         return ans;
//     }
// }