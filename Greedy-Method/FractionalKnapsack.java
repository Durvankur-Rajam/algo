import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {

    // Item class to store value, weight, and value/weight ratio
    static class Item {
        int value, weight;
        double ratio;

        Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
            this.ratio = (double) value / weight;
        }
    }

    // Function to get maximum value using fractional knapsack greedy approach
    public static double fractionalKnapsack(int capacity, Item[] items) {
        // Sort items by value/weight ratio in decreasing order
        Arrays.sort(items, new Comparator<Item>() {
            public int compare(Item a, Item b) {
                return Double.compare(b.ratio, a.ratio);
            }
        });

        double totalValue = 0.0;
        int remainingCapacity = capacity;

        for (Item item : items) {
            if (item.weight <= remainingCapacity) {
                // Take whole item
                remainingCapacity -= item.weight;
                totalValue += item.value;
            } else {
                // Take fractional part of the item
                double fraction = ((double) remainingCapacity) / item.weight;
                totalValue += item.value * fraction;
                break; // Knapsack is full
            }
        }
        return totalValue;
    }

    public static void main(String[] args) {
        int capacity = 50;
        Item[] items = {
            new Item(60, 10),
            new Item(100, 20),
            new Item(120, 30)
        };

        double maxValue = fractionalKnapsack(capacity, items);
        System.out.println("Maximum value in Knapsack = " + maxValue);
    }
}

