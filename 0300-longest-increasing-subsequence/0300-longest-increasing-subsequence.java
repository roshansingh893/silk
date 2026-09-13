class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp , -1);

        int max = 0;

        for(int i = 0; i < n; i++){
            max = Math.max(max , solve(nums , dp , n , i));
        }

        return  max;
    }


    public int solve(int[] nums , int[] dp , int n , int i){
        if(dp[i] != -1){
            return dp[i];
        }
          int count = 1;
        for(int j = i; j < n; j++){
            if(nums[j] > nums[i]){
                count = Math.max(count , 1 + solve(nums , dp , n , j));
            }
        }

        return   dp[i] =  count;
    }
}