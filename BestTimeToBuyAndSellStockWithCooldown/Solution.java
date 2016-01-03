package BestTimeToBuyAndSellStockWithCooldown;

/**
 * Created by Alan on 1/3/2016.
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int profitSell = 0, profitDoNothing = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int tmp = profitSell;
            profitSell = Math.max(profitSell + prices[i + 1] - prices[i], profitDoNothing);
            profitDoNothing = Math.max(tmp, profitDoNothing);
        }

        return Math.max(profitDoNothing, profitSell);
    }
}
