package BestTimeToBuyAndSellStockIV;

/**
 * Created by Alan on 12/13/2015.
 */
public class Solution {
    public int maxProfit(int k, int[] prices) {
        if (k < 1) {
            return 0;
        }
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        if (k >= prices.length / 2) {
            int ret = 0;
            for (int i = 0; i < prices.length - 1; i++) {
                if (prices[i + 1] > prices[i]) {
                    ret += prices[i + 1] - prices[i];
                }
            }
            return ret;
        }

        // Solution 1:
        int lastIsSelling[] = new int[k + 1];
        int lastIsBuying[] = new int[k + 1];

        for (int i = 0; i < k + 1; i++) {
            lastIsBuying[i] = Integer.MIN_VALUE;
        }

        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < k; j++) {
                lastIsSelling[j + 1] = Math.max(lastIsSelling[j + 1], lastIsBuying[j + 1] + prices[i]);
                lastIsBuying[j + 1] = Math.max(lastIsBuying[j + 1], lastIsSelling[j] - prices[i]);
            }
        }

        return lastIsSelling[k];

        // Solution 2:
//        int[][] local = new int[prices.length][k + 1];
//        int[][] global = new int[prices.length][k + 1];
//
//        for (int i = 1; i < prices.length; i++) {
//            int diff = prices[i] - prices[i - 1];
//            for (int j = 1; j <= k; j++) {
//                local[i][j] = Math.max(
//                        global[i - 1][j - 1] + Math.max(diff, 0),
//                        local[i - 1][j] + diff);
//                global[i][j] = Math.max(global[i - 1][j], local[i][j]);
//            }
//        }
//
//        return global[prices.length - 1][k];
    }
}
