class Solution {

    static final int MAX = 100000;
    static final boolean[] dp = new boolean[MAX + 1];

    static {
        for (int i = 1; i <= MAX; i++) {
            for (int j = 1; j * j <= i; j++) {
                if (!dp[i - j * j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
    }
    public boolean winnerSquareGame(int n) {
        return dp[n];
    }
}