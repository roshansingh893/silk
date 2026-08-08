class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int lo = 0;
        int hi = position[position.length-1];
        int optimal = 0;
        while (lo <= hi) {
            int mid = lo + (hi-lo)/2;
            if (canPut(position, m, mid)) {
                optimal = mid;
                lo = mid+1;
            } else {
                hi = mid-1;
            }
        }
        return optimal;
    }
    private boolean canPut(int[] positions, int m, int max) {
        int count = 1;
        int last = positions[0];
        for (int i = 0; i < positions.length; i++) {
            if (positions[i] - last >= max) {
                last = positions[i];
                count++;
            }
        }
        return count >= m;
    }
}