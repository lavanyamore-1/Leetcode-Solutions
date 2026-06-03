class Solution {
    private int[][] memo;

    private boolean dfs(int i, int j, String s, String p) {
        if (memo[i][j] != -1) {
            return memo[i][j] == 1;
        }

        boolean ans;

        if (j == p.length()) {
            ans = (i == s.length());
        } else {
            boolean firstMatch =
                (i < s.length() &&
                 (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));

            if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                ans = dfs(i, j + 2, s, p) ||
                      (firstMatch && dfs(i + 1, j, s, p));
            } else {
                ans = firstMatch &&
                      dfs(i + 1, j + 1, s, p);
            }
        }

        memo[i][j] = ans ? 1 : 0;
        return ans;
    }

    public boolean isMatch(String s, String p) {
        memo = new int[s.length() + 1][p.length() + 1];

        for (int i = 0; i <= s.length(); i++) {
            Arrays.fill(memo[i], -1);
        }

        return dfs(0, 0, s, p);
    }
}