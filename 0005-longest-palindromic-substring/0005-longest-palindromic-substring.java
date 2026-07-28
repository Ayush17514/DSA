class Solution {
    private int start = 0;
    private int maxLen = 0;

    public String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2) return s;

        for (int i = 0; i < n; i++) {
            expand(s, i, i);     // Odd length palindromes (e.g., "aba")
            expand(s, i, i + 1); // Even length palindromes (e.g., "abba")
        }

        return s.substring(start, start + maxLen);
    }

    private void expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        
        int currentLen = right - left - 1;
        if (currentLen > maxLen) {
            maxLen = currentLen;
            start = left + 1;
        }
    }
}
