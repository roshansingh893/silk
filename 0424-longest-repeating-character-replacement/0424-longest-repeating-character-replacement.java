class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left = 0;
        int right = 0;
        int maxcount = 0;
        while (right < s.length()) {

    freq[s.charAt(right) - 'A']++;

    int max = Arrays.stream(freq).max().getAsInt();

    if (right - left + 1 - max > k) {
        freq[s.charAt(left) - 'A']--;
        left++;
    }

    maxcount = Math.max(maxcount, right - left + 1);

    right++;
}

        return maxcount;
    }
}