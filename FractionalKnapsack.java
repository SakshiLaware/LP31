import java.util.*;

public class FractionalKnapsack {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        double[] profit = new double[n];
        double[] weight = new double[n];
        double[] ratio = new double[n];

        System.out.print("Enter knapsack capacity: ");
        double W = sc.nextDouble();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter profit and weight of item " + (i + 1) + ": ");
            profit[i] = sc.nextDouble();
            weight[i] = sc.nextDouble();

            ratio[i] = profit[i] / weight[i];
        }

        // Sort items by profit/weight ratio
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (ratio[i] < ratio[j]) {
                    double temp = ratio[i];
                    ratio[i] = ratio[j];
                    ratio[j] = temp;

                    temp = profit[i];
                    profit[i] = profit[j];
                    profit[j] = temp;

                    temp = weight[i];
                    weight[i] = weight[j];
                    weight[j] = temp;
                }
            }
        }

        double totalProfit = 0;

        for (int i = 0; i < n; i++) {

            if (weight[i] <= W) {
                W -= weight[i];
                totalProfit += profit[i];

                System.out.println("Item " + (i + 1) + ": Fully selected");
            } else {
                double fraction = W / weight[i];
                totalProfit += profit[i] * fraction;

                System.out.println("Item " + (i + 1) +
                        ": " + fraction + " selected");

                break;
            }
        }

        System.out.println("Maximum Profit = " + totalProfit);

        sc.close();
    }
}