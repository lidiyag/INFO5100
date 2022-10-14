package Assignment4;

import java.util.ArrayList;

public class WeightedGrade {

    private ArrayList<Integer> pointsTotal= new ArrayList<>();

    private ArrayList<Double> earnedPoints=new ArrayList<>();

    private ArrayList<Double> assignmentPercentage=new ArrayList<>();

    private ArrayList<Double> weightedGradeIndividual =new ArrayList<>();

    private double TotalWeightedGrade;

    private String grade;

    public void WeightedGrade(){ // constructor for WeightedGrade
    }

    public void setPointsTotal(ArrayList<Integer> pointsTotal) { // setter for Total Points
        for (int i = 0; i < pointsTotal.size(); i++) {
             this.pointsTotal.add(pointsTotal.get(i));
        }
    }

    public void setAssignmentPercentage(ArrayList<Double> assignmentPercentage) { // setter for Assignment Percentage
        for (int i = 0; i < assignmentPercentage.size(); i++) {
            this.assignmentPercentage.add(assignmentPercentage.get(i)) ;
        }
    }

    public void setEarnedPoints(ArrayList<Double> earnedPoints) { // setter for Earned Points
        for (int i = 0; i < earnedPoints.size(); i++) {
            this.earnedPoints.add(earnedPoints.get(i));
        }
    }

    public ArrayList<Integer> getPointsTotal(){ // getter for Total Points
        return pointsTotal;
    }

    public ArrayList<Double> getEarnedPoints(){ // getter for Earned Points
        return earnedPoints;
    }

    public ArrayList<Double> getAssignmentPercentage(){ // getter for AssignmentPercentage
        return assignmentPercentage;
    }

    public void calculateWeightedGrade() { // method for calculating weighted grade for individual inputs
        for (int i = 0; i < pointsTotal.size(); i++) {
           // weightedGradeIndividual[i] = earnedPoints[i] / pointsTotal[i] * (assignmentPercentage[i] / 100) * 100;
            weightedGradeIndividual.add((earnedPoints.get(i)/pointsTotal.get(i)*assignmentPercentage.get(i)));
        }
    }

    public double calculateTotalWeightedGrade(){ // method for calculating Total Weighted Grade
        TotalWeightedGrade=0.0;
        for(int i=0;i<pointsTotal.size();i++){
           // TotalWeightedGrade=TotalWeightedGrade+ weightedGradeIndividual[i];
            TotalWeightedGrade=TotalWeightedGrade+ weightedGradeIndividual.get(i);
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
