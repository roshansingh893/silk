import java.util.*;

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = Arrays.stream(piles).max().getAsInt();

        while (left < right) {
            int mid = left + (right - left) / 2;
            int totalHours = 0;
            
            for (int pile : piles) {
                totalHours += Math.ceil((double)pile/mid);
            }
            
            if (totalHours <= h) {
                right = mid;
            } else {
                left = mid + 1;  
            }
        }
        
        return left;
    }
}
