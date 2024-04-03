import java.util.*;

public class HousingPriceAnalyzer {
    
    public static void main(String[] args) {

        List<Double> prices = Arrays.asList(150000.0, 220000.0, 180000.0, 280000.0, 320000.0, 200000.0, 350000.0);
        List<Double> squareFootages = Arrays.asList(1200.0, 1800.0, 1500.0, 2000.0, 2200.0, 1600.0, 2400.0);
        

        double[] priceRanges = {100000.0, 200000.0, 300000.0, 400000.0, Double.MAX_VALUE};
        

        int[] houseCount = new int[priceRanges.length];
        double[] footageSum = new double[priceRanges.length];
        

        for (int i = 0; i < prices.size(); i++) {
            double price = prices.get(i);
            double squareFootage = squareFootages.get(i);
            

            int rangeIndex = findPriceRangeIndex(price, priceRanges);
            

            houseCount[rangeIndex]++;
            footageSum[rangeIndex] += squareFootage;
        }
        

        System.out.println("Price Range\t\tNumber of Houses\t\tAverage Square Footage");
        for (int i = 0; i < priceRanges.length - 1; i++) {
            String range = "$" + priceRanges[i] + "-" + priceRanges[i + 1];
            double averageFootage = houseCount[i] == 0 ? 0 : footageSum[i] / houseCount[i];
            System.out.printf("%-20s\t\t%-20d\t\t%-20.2f\n", range, houseCount[i], averageFootage);
        }
    }
    

    private static int findPriceRangeIndex(double price, double[] priceRanges) {
        for (int i = 0; i < priceRanges.length - 1; i++) {
            if (price >= priceRanges[i] && price < priceRanges[i + 1]) {
                return i;
            }
        }

        return priceRanges.length - 1;
    }
}