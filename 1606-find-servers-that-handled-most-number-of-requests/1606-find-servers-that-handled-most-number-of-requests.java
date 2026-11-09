import java.util.*;

class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        // Min-heap to store active servers: {free_time, server_id}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        
        // Fast O(1) availability lookup
        boolean[] available = new boolean[k];
        Arrays.fill(available, true);
        
        // TreeSet to find the next available server using higher() (equivalent to upper_bound)
        TreeSet<Integer> available2 = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            available2.add(i);
        }

        int[] result = new int[k];

        for (int i = 0; i < arrival.length; i++) {
            int time = arrival[i];
            int neededServer = i % k;

            // Free up servers whose tasks have finished by the current arrival time
            while (!pq.isEmpty() && pq.peek()[0] <= time) {
                int server = pq.poll()[1];
                available[server] = true;
                available2.add(server);
            }

            if (available2.isEmpty()) {
                continue; // All servers are busy, drop request
            }

            int assignedServer = -1;
            if (available[neededServer]) {
                assignedServer = neededServer;
            } else {
                // Find the next available server >= neededServer
                Integer it = available2.ceiling(neededServer);
                if (it != null) {
                    assignedServer = it;
                } else {
                    assignedServer = available2.first(); // Wrap around to the start
                }
            }

            // Allocate the server
            available[assignedServer] = false;
            available2.remove(assignedServer);
            result[assignedServer]++;
            pq.offer(new int[]{time + load[i], assignedServer});
        }

        // Find the maximum number of requests handled by any server
        int maxVal = 0;
        for (int val : result) {
            maxVal = Math.max(maxVal, val);
        }

        List<Integer> maxIndices = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (result[i] == maxVal) {
                maxIndices.add(i);
            }
        }

        return maxIndices;
    }
}