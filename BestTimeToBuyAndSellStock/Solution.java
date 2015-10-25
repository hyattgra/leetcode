package BestTimeToBuyAndSellStock;

/**
 * Created by Alan on 7/30/15.
 */
public class Solution {

    public static void main(String[] args) {
        int[] test = {2, 6, 7, 3, 1};
        System.out.print(maxProfit(test));
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int maxProfit = Integer.MIN_VALUE;
        int minPrice = Integer.MAX_VALUE;
        for (int i : prices) {
            minPrice = Math.min(i, minPrice);
            maxProfit = Math.max(i - minPrice, maxProfit);
        }
        return maxProfit;
    }
}
