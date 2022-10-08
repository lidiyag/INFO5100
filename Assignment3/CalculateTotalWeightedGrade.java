package Assignment3;

import java.util.Scanner;

public class CalculateTotalWeightedGrade {
    public static void main(String[] args) {

        WeightedGrade weightedGrade = new WeightedGrade();
        int totalPoints[]=new int[8];
        double earnedPoints[]=new double[8];
        double assignmentPercentage[]=new double[8];

        System.out.print("Enter the 8 values for total points\n"); // Read Total Points from user
        for(int i=0;i<8;i++){
            Scanner scanner = new Scanner(System.in);
            totalPoints[i] = scanner.nextInt();
        }
        weightedGrade.setPointsTotal(totalPoints); // Set value for Total Points

        System.out.print("\nEnter earned points\n"); // Read Earned Points from user
        for(int i=0;i<8;i++) {
            Scanner scanner = new Scanner(System.in);
            earnedPoints[i] = scanner.nextDouble();
        }
        weightedGrade.setEarnedPoints(earnedPoints); // Set value for Earned Points

        System.out.print("\nEnter assignment percentage\n"); // Read Assignment percentage from user
        for(int i=0;i<8;i++) {
            Scanner scanner = new Scanner(System.in);
            assignmentPercentage[i] = scanner.nextDouble();
        }
        weightedGrade.setAssignmentPercentage(assignmentPercentage); // Set value for Assignment Percentage

        weightedGrade.calculateWeightedGrade(); // Calculates Weighted Grade
        double totalWeightGrade = weightedGrade.calculateTotalWeightedGrade(); // Calculates Total Weighted Grade
        System.out.print("\nWeighted average is:");
        System.out.printf("%.3f\n", totalWeightGrade);

        weightedGrade.setGrade(); // Sets the grade
        System.out.print("\nGrade is "+weightedGrade.getGrade()); // Gets the grade
    }
}
