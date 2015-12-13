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

        int lastIsSelling[] = new int[k + 1];
        int lastIsBuying[] = new int[k + 1];

        for (int i = 0; i < k + 1; i++) {
            lastIsBuying[i] = Integer.MIN_VALUE;
            lastIsSelling[i] = 0;
        }

        for (int i = 0; i < prices.length; i++) {
            for (int j = k; j > 0; j--) {
                lastIsSelling[j] = Math.max(lastIsSelling[j], lastIsBuying[j] + prices[i]);
                lastIsBuying[j] = Math.max(lastIsBuying[j], lastIsSelling[j - 1] - prices[i]);

            }
        }

        return lastIsSelling[k];
    }
}
