package CoinChange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Alan on 1/31/2016.
 */
public class Solution {
    public int coinChange(int[] coins, int amount) {

        if (coins == null || coins.length == 0 || amount <= 0)
            return 0;

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (Integer coin : coins) {
                if (coin <= i && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }

        if (dp[amount] == Integer.MAX_VALUE) {
            return -1;
        }

        return dp[amount];
    }
}
