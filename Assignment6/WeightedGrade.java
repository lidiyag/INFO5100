package Assignment6;

public class WeightedGrade { // class weighted grade with attributes and methods
    private int pointsTotal;
    private double earnedPoints;
    private double assignmentPercentage;
    private double totalWeightedGrade;

    public void WeightedGrade(){ // constructor for WeightedGrade
    }

    public void setPointsTotal(int pointsTotal){ // setter for Total Points
        this.pointsTotal=pointsTotal;
    }

    public void setAssignmentPercentage(double assignmentPercentage) { // setter for Assignment Percentage
        this.assignmentPercentage = assignmentPercentage;
    }

    public void setEarnedPoints(double earnedPoints){ // setter for Earned Points
        this.earnedPoints=earnedPoints;
    }

    public double getPointsTotal(){ // getter for Total Points
        return pointsTotal;
    }

    public double getEarnedPoints(){ // getter for Earned Points
        return earnedPoints;
    }

    public double getAssignmentPercentage(){ // getter for AssignmentPercentage
        return assignmentPercentage;
    }

    public void calculateTotalWeightedGrade(){ // method for calculating Total Weighted Grade
        totalWeightedGrade=earnedPoints/pointsTotal*(assignmentPercentage/100)*100;
    }

    public double getTotalWeightedGrade(){ // getter for Total Weighted Grade
        return totalWeightedGrade;
    }

}
