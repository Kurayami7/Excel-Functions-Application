package gui_swing_events;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Excel {
    private ArrayList<Double> userInputNo;
    ArrayList<Double> numbers = new ArrayList();

    // Constructor 1: Initializing Excel with a list of doubles
    public Excel(ArrayList<Double> inputDouble) {
        this.userInputNo = inputDouble;
    }

    // Constructor 2: Initializing Excel with a space-separated string of numbers
    public Excel(String userInputString) {
        // Split the input string into an array of strings
        String[] strNumArray = userInputString.split(" ");

        // Converting the array into a list
        List<String> strNumList = Arrays.asList(strNumArray);

        // Creating an ArrayList from the list
        ArrayList<String> strNumArrayList = new ArrayList<>(strNumList);

        // Converting the strings to doubles and store in the 'numbers' list
        strNumArrayList.forEach(item -> {
            double itemAsDouble = Double.parseDouble(item);
            numbers.add(itemAsDouble);
        });
    }

    // Method 1: Finding and return the total of all numbers
    public Double findTotal() {
        double total = 0.0;
        for (Double num : numbers) {
            total += num;
        }
        return total;
    }

    // Method 2: Finding and return the average of all numbers
    public Double findAvg() {
        double avg = 0.0;
        for (Double num : numbers) {
            double total = findTotal();
            avg = total / numbers.size();
        }
        return avg;
    }

    // Method 3: Finding and return the maximum value in the list
    public Double findMax() {
        double max = 0.0;
        for (Double num : numbers) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    // Method 4: Finding and return the minimum value in the list
    public Double findMin() {
        double min = Double.POSITIVE_INFINITY;
        for (Double num : numbers) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }
}
