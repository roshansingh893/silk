import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        int n = nums.length;

        // First loop: fix the first element
        for (int i = 0; i < n; i++) {

            // This set is reset for every i
            Set<Integer> seen = new HashSet<>();

            // Second loop: fix the second element
            for (int j = i + 1; j < n; j++) {

                int third = - (nums[i] + nums[j]);

                // Check if third element already seen
                if (seen.contains(third)) {
                    List<Integer> triplet = Arrays.asList(nums[i], nums[j], third);
                    Collections.sort(triplet);   // normalize
                    result.add(triplet);         // set removes duplicates
                }

                // Add nums[j] AFTER checking
                seen.add(nums[j]);
            }
        }

        return new ArrayList<>(result);
    }
}
