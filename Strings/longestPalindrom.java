class Solution {

    public String findPalindrome(String s, int left, int right) {

        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return s.substring(left + 1, right);
    }

    public String longestPalindrome(String s) {

        String ans = "";

        for (int i = 0; i < s.length(); i++) {

            // Odd length palindrome
            String odd = findPalindrome(s, i, i);

            // Even length palindrome
            String even = findPalindrome(s, i, i + 1);

            if (odd.length() > ans.length()) {
                ans = odd;
            }

            if (even.length() > ans.length()) {
                ans = even;
            }
        }

        return ans;
    }
}