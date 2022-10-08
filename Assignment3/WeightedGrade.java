package Assignment3;

public class WeightedGrade { // class weighted grade with attributes and methods
    private int[] pointsTotal=new int[8];
    private double[] earnedPoints=new double[8];
    private double[] assignmentPercentage=new double[8];

    private double[] weightedGradeIndividual =new double[8];

    private double TotalWeightedGrade;

    private String grade;

    public void WeightedGrade(){ // constructor for WeightedGrade
    }

    public void setPointsTotal(int pointsTotal[]) { // setter for Total Points
        for (int i = 0; i < 8; i++) {
            this.pointsTotal[i] = pointsTotal[i];
        }
    }

    public void setAssignmentPercentage(double assignmentPercentage[]) { // setter for Assignment Percentage
        for (int i = 0; i < 8; i++) {
            this.assignmentPercentage[i] = assignmentPercentage[i];
        }
    }

    public void setEarnedPoints(double earnedPoints[]) { // setter for Earned Points
        for (int i = 0; i < 8; i++) {
            this.earnedPoints[i] = earnedPoints[i];
        }
    }

    public int[] getPointsTotal(){ // getter for Total Points
        return pointsTotal;
    }

    public double[] getEarnedPoints(){ // getter for Earned Points
        return earnedPoints;
    }

    public double[] getAssignmentPercentage(){ // getter for AssignmentPercentage
        return assignmentPercentage;
    }

    public void calculateWeightedGrade() { // method for calculating weighted grade for individual inputs
        for (int i = 0; i < 8; i++) {
            weightedGradeIndividual[i] = earnedPoints[i] / pointsTotal[i] * (assignmentPercentage[i] / 100) * 100;
        }
    }

    public double calculateTotalWeightedGrade(){ // method for calculating Total Weighted Grade
        TotalWeightedGrade=0.0;
        for(int i=0;i<8;i++){
            TotalWeightedGrade=TotalWeightedGrade+ weightedGradeIndividual[i];
        }
        return TotalWeightedGrade;
    }

    public void setGrade(){ // setter for Grade
        if(TotalWeightedGrade>=90){
            grade="A";
        }
        else if(TotalWeightedGrade>=80 && TotalWeightedGrade<=89.999){
            grade="B";
        }else if(TotalWeightedGrade>=70 && TotalWeightedGrade<80){
            grade="C";
        }else if (TotalWeightedGrade>=60 && TotalWeightedGrade<70){
            grade="D";
        }else {
            grade="F";
        }
    }

    public String getGrade(){ // getter for Grade
        return grade;
    }
}
