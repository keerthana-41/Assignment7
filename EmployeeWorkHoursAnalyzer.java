import java.util.*;

public class EmployeeWorkHoursAnalyzer {
    public static void main(String[] args) {
        List<Double> workHours = Arrays.asList(38.0, 40.0, 42.0, 35.0, 45.0, 30.0, 40.0, 55.0);

        Map<String, Integer> hoursGroups = new LinkedHashMap<>();
        hoursGroups.put("Less than 40 hours", 0);
        hoursGroups.put("Exactly 40 hours", 0);
        hoursGroups.put("More than 40 hours", 0);

        Map<String, Double> avgHoursPerDay = new LinkedHashMap<>();
        avgHoursPerDay.put("Less than 40 hours", 0.0);
        avgHoursPerDay.put("Exactly 40 hours", 0.0);
        avgHoursPerDay.put("More than 40 hours", 0.0);

        for (Double hours : workHours) {
            if (hours < 40.0) {
                hoursGroups.put("Less than 40 hours", hoursGroups.get("Less than 40 hours") + 1);
                avgHoursPerDay.put("Less than 40 hours", avgHoursPerDay.get("Less than 40 hours") + (hours / 7));
            } else if (hours == 40.0) {
                hoursGroups.put("Exactly 40 hours", hoursGroups.get("Exactly 40 hours") + 1);
                avgHoursPerDay.put("Exactly 40 hours", avgHoursPerDay.get("Exactly 40 hours") + (hours / 7));
            } else {
                hoursGroups.put("More than 40 hours", hoursGroups.get("More than 40 hours") + 1);
                avgHoursPerDay.put("More than 40 hours", avgHoursPerDay.get("More than 40 hours") + (hours / 7));
            }
        }

        for (Map.Entry<String, Integer> entry : hoursGroups.entrySet()) {
            String key = entry.getKey();
            System.out.println("Group: " + key +
                    ", Number of Employees: " + entry.getValue() +
                    ", Average Hours per Day: " + avgHoursPerDay.get(key));
        }
    }
}