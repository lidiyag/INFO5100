package Assignment4;

import java.util.ArrayList;
import java.util.Scanner;

public class CalculateGrade {
    public static void main(String[] args){

        WeightedGrade weightedGrade = new WeightedGrade();
        ArrayList<Integer> totalPoints=new ArrayList<>();
        ArrayList<Double> earnedPoints=new ArrayList<>();
        ArrayList<Double> assignmentPercentage=new ArrayList<>();
        int numInputs;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of inputs");
        numInputs=scanner.nextInt();

        System.out.print("Enter the values for total points\n"); // Read Total Points from user
        for(int i=0;i<numInputs;i++){
            totalPoints.add(scanner.nextInt());
        }
        weightedGrade.setPointsTotal(totalPoints); // Set value for Total Points

        System.out.print("\nEnter earned points\n"); // Read Earned Points from user
        for(int i=0;i<numInputs;i++) {
            earnedPoints.add(scanner.nextDouble());
        }
        weightedGrade.setEarnedPoints(earnedPoints); // Set value for Earned Points

        System.out.print("\nEnter assignment percentage\n"); // Read Assignment percentage from user
        for(int i=0;i<numInputs;i++) {
            assignmentPercentage.add(scanner.nextDouble());
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
