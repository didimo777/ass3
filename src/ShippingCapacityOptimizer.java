import java.util.*;

public class ShippingCapacityOptimizer {

    public static boolean checkIfCapacityIsEnough(int[] packageWeights, int allowedDays, int capacityLimit) {
        int currentLoad = 0;
        int requiredDays = 1;

        for (int weight : packageWeights) {
            if (currentLoad + weight > capacityLimit) {
                requiredDays++;
                currentLoad = 0;
            }
            currentLoad += weight;
        }

        return requiredDays <= allowedDays;
    }

    public static int findMinimumCapacity(int[] packageWeights, int allowedDays) {
        int minimumCapacity = 0;
        int maximumCapacity = 0;

        for (int weight : packageWeights) {
            if (weight > minimumCapacity) minimumCapacity = weight;
            maximumCapacity += weight;
        }

        while (minimumCapacity < maximumCapacity) {
            int middleCapacity = (minimumCapacity + maximumCapacity) / 2;

            if (checkIfCapacityIsEnough(packageWeights, allowedDays, middleCapacity)) {
                maximumCapacity = middleCapacity;
            } else {
                minimumCapacity = middleCapacity + 1;
            }
        }

        return minimumCapacity;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int packageCount = scanner.nextInt();
        int[] packageWeights = new int[packageCount];

        for (int i = 0; i < packageCount; i++) {
            packageWeights[i] = scanner.nextInt();
        }

        int daysLimit = scanner.nextInt();

        System.out.println(findMinimumCapacity(packageWeights, daysLimit));
    }
}