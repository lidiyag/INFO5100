package Assignment6;

public class Main {
    //calls methods of WeightedGrade class for calculating the weighted grade
    public static double calculateGrade(double earned,int total,double percent){
        WeightedGrade weightedGrade=new WeightedGrade();
        weightedGrade.setPointsTotal(total);
        weightedGrade.setEarnedPoints(earned);
        weightedGrade.setAssignmentPercentage(percent);
        weightedGrade.calculateTotalWeightedGrade(); // Calculate the Total Weighted Grade
        double totalWeightGrade=weightedGrade.getTotalWeightedGrade();
        return totalWeightGrade;
    }

    public static void main(String[] args){
      new AddGUI(); //invoking the GUI for WeightedGrade Application
    }

}
