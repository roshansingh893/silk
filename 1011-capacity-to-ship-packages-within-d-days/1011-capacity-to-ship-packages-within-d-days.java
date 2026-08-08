class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int left = Arrays.stream(weights).max().getAsInt();
        int right = Arrays.stream(weights).sum();

        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (canShip(weights, D, mid)) {
                right = mid; 
            } else {
                left = mid + 1;
            }
        }
        
        // Step 4: Return the minimum capacity
        return left;  // or right, as left == right
    }

    private boolean canShip(int[] weights, int D, int capacity) {
        int days = 1;  
        int currentLoad = 0;

        for (int weight : weights) {
            if (currentLoad + weight > capacity) {
                days++;  
                currentLoad = 0;  
            }
            currentLoad += weight;
        }

        return days <= D;  // Return true if within the allowed days
    }
}
