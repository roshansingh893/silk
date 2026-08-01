import java.util.*;

class Solution {
    
    public int networkDelayTime(int[][] times, int n, int k) {

        List<List<int[]>> graph = new ArrayList<>();
        
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] edge : times) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            
            graph.get(u).add(new int[]{v, w});
        }
        
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        dist[k] = 0; // source node
        
        
                PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );
        
        pq.offer(new int[]{0, k}); // start from source
        
        
        // Step 4: Dijkstra
        while (!pq.isEmpty()) {
            
            int[] current = pq.poll();
            int currTime = current[0];
            int node = current[1];
            
            
            // Explore neighbors
            for (int[] neighbor : graph.get(node)) {
                
                int nextNode = neighbor[0];
                int weight = neighbor[1];
                
                int newTime = currTime + weight;
                
                
                // Relaxation step
                if (newTime < dist[nextNode]) {
                    
                    dist[nextNode] = newTime;
                    
                    // Push updated state into PQ
                    pq.offer(new int[]{newTime, nextNode});
                }
            }
        }
        
        
        // Step 5: Find maximum time
        int maxTime = 0;
        
        for (int i = 1; i <= n; i++) {
            
            // If any node is unreachable
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }
            
            maxTime = Math.max(maxTime, dist[i]);
        }
        
        return maxTime;
    }
}