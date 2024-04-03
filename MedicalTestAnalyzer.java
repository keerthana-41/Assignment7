import java.util.*;

public class MedicalTestAnalyzer {
    public static void main(String[] args) {
        List<Double> testResults = Arrays.asList(70.0, 90.0, 110.0, 130.0, 150.0, 170.0, 190.0, 210.0);
        Map<String, Integer> resultRanges = new LinkedHashMap<>();
        resultRanges.put("Normal", 0);
        resultRanges.put("Borderline", 0);
        resultRanges.put("High", 0);

        Map<String, Double> averageValuePerRange = new LinkedHashMap<>();
        averageValuePerRange.put("Normal", 0.0);
        averageValuePerRange.put("Borderline", 0.0);
        averageValuePerRange.put("High", 0.0);

        Map<String, Integer> countPerRange = new LinkedHashMap<>();
        countPerRange.put("Normal", 0);
        countPerRange.put("Borderline", 0);
        countPerRange.put("High", 0);

        double normalThreshold = 100.0;
        double borderlineThreshold = 150.0;

        for (Double result : testResults) {
            if (result <= normalThreshold) {
                resultRanges.put("Normal", resultRanges.get("Normal") + 1);
                averageValuePerRange.put("Normal", averageValuePerRange.get("Normal") + result);
                countPerRange.put("Normal", countPerRange.get("Normal") + 1);
            } else if (result <= borderlineThreshold) {
                resultRanges.put("Borderline", resultRanges.get("Borderline") + 1);
                averageValuePerRange.put("Borderline", averageValuePerRange.get("Borderline") + result);
                countPerRange.put("Borderline", countPerRange.get("Borderline") + 1);
            } else {
                resultRanges.put("High", resultRanges.get("High") + 1);
                averageValuePerRange.put("High", averageValuePerRange.get("High") + result);
                countPerRange.put("High", countPerRange.get("High") + 1);
            }
        }

        for (Map.Entry<String, Integer> entry : resultRanges.entrySet()) {
            String key = entry.getKey();
            System.out.println("Result Range: " + key +
                    ", Number of Patients: " + entry.getValue() +
                    ", Average Value: " + (averageValuePerRange.get(key) / countPerRange.get(key)));
        }
    }
}