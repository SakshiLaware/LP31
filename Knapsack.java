import java.util.*;

public class Knapsack {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        int[] profit = new int[n];
        int[] weight = new int[n];

        System.out.println("Enter profit and weight of each item:");

        for (int i = 0; i < n; i++) {
            profit[i] = sc.nextInt();
            weight[i] = sc.nextInt();
        }

        System.out.print("Enter knapsack capacity: ");
        int W = sc.nextInt();

        int[][] dp = new int[n + 1][W + 1];
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= W; w++) {

                if (weight[i - 1] <= w) {
                    dp[i][w] = Math.max(
                        profit[i - 1] + dp[i - 1][w - weight[i - 1]],
                        dp[i - 1][w]
                    );
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        System.out.println("Maximum Profit: " + dp[n][W]);

        int w = W;

        for (int i = n; i > 0; i--) {
            if (dp[i][w] != dp[i - 1][w]) {
                System.out.println("Item " + i + " selected");
                w -= weight[i - 1];
            }
        }

        sc.close();
    }
}