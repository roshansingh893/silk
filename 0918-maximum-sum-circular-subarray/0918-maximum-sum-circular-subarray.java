class Solution {
     public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int maxSum = nums[0];
        int currentSum = nums[0];

        for(int i = 1; i < n; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);

            maxSum = Math.max(maxSum, currentSum);
        }

        int totalSum = 0;
        for(int num : nums) {
            totalSum += num;
        }

        int minSum = nums[0];
        int currentMin = nums[0];

        for(int i = 1;  i < n; i++) {
            currentMin = Math.min(nums[i], currentMin + nums[i]);
            minSum = Math.min(minSum, currentMin);
        }

        int ans = (minSum == totalSum) ? minSum : totalSum - minSum;

        return Math.max(maxSum, ans);
    }
}