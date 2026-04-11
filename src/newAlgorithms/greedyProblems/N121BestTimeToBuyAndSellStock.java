package newAlgorithms.greedyProblems;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
public class N121BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int buyPrice = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (buyPrice > prices[i]) {
                buyPrice = prices[i];
            }

            profit = Math.max(profit, prices[i] - buyPrice);
        }

        return profit;
    }
}
