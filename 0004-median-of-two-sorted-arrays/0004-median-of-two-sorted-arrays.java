class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n = nums1.length;
        int m = nums2.length;

        int total = n + m;
        int i = 0, j = 0;

        int prev = 0, curr = 0;
        for (int count = 0; count <= total / 2; count++) {

            prev = curr;

            if (j == m || (i < n && nums1[i] <= nums2[j])) {
                curr = nums1[i++];
            } else {
                curr = nums2[j++];
            }
        }

        if (total % 2 == 1) {
            return curr;
        }

        return (prev + curr) / 2.0;
    }
}

