class Solution {

    // Can we split the array into at most k subarrays
    // such that no subarray sum exceeds maxAllowedSum?
    private boolean canSplit(int[] nums, long maxAllowedSum, int k) {

        int partitions = 1;
        long currentSum = 0;

        for (int num : nums) {

            // Single element itself exceeds limit
            if (num > maxAllowedSum) {
                return false;
            }

            // Keep extending current partition
            if (currentSum + num <= maxAllowedSum) {
                currentSum += num;
            }

            // Need a new partition
            else {
                partitions++;
                currentSum = num;

                // Too many partitions used
                if (partitions > k) {
                    return false;
                }
            }
        }

        return true;
    }

    public int splitArray(int[] nums, int k) {

        long maxElement = 0;
        long totalSum = 0;

        // Search Space:
        // Left  = largest element
        // Right = sum of entire array

        for (int num : nums) {
            maxElement = Math.max(maxElement, num);
            totalSum += num;
        }

        long left = maxElement ; // definitely invalid
        long right = totalSum;      // definitely valid
   int ans = 0;
        // First True Binary Search
        while (left <= right) {

            long mid = left + (right - left) / 2;

            if (canSplit(nums, mid, k)) {
                ans = (int)mid;
                right = mid - 1; // try smaller answer
            } else {
                left = mid + 1;  // need larger answer
            }
        }

        return (int) ans;
    }
}