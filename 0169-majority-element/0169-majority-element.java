class Solution {
    public int majorityElement(int[] nums) {
        
 // currteam , count , 
            int currteam = nums[0];
              int count = 1;
               for ( int i =1; i< nums.length; i ++ ){
                if ( count == 0){
                    currteam = nums[i];
                }
                     if(nums[i] != currteam) {
                     count--;
                     }
                     else {
                        count++;
                     }
               }

               return currteam;
    }
}