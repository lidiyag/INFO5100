package Assignment6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class AddGUI extends JFrame implements ActionListener{
    //initializing labels and textfields for totalpoints, earnedpoints and assignment percentage
    JLabel earnedPointsLabel=new JLabel("Enter Earned Points");
    JTextField earnedPoints=new JTextField(20);
    JLabel totalPointsLabel=new JLabel("Enter Total Points");
    JTextField totalPoints=new JTextField(20);
    JLabel assignmentPercentageLabel=new JLabel("Enter Assignment Percentage");
    JTextField assignmentPercentage=new JTextField(20);
    JButton calculate=new JButton("Click to calculate score"); //button for calculating the weighted grade score
    JTextArea weightedScore=new JTextArea(); //textarea for displaying weighted grade

    public AddGUI(){ //constructor
        //setting application title and layout
        setTitle("Weighted Grade Application");
        setLayout(new FlowLayout());
        setVisible(true);
        setSize(800,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //adding all elements to the frame
        add(earnedPointsLabel);
        add(earnedPoints);
        earnedPointsLabel.setLabelFor(earnedPoints);
        add(totalPointsLabel);
        add(totalPoints);
        totalPointsLabel.setLabelFor(totalPoints);
        add(assignmentPercentageLabel);
        add(assignmentPercentage);
        assignmentPercentageLabel.setLabelFor(assignmentPercentage);
        add(calculate);
        calculate.addActionListener(this);
        add(weightedScore);
    }

    public void actionPerformed(ActionEvent ae){ //action to be performed on button click
        //gets data entered by user from gui
        double earned=Double.parseDouble(earnedPoints.getText());
        double percent=Double.parseDouble(assignmentPercentage.getText());
        int total=Integer.parseInt(totalPoints.getText());
        //passes these parameters to main for calculating the grade
        double totalWeightGrade=Main.calculateGrade(earned,total,percent);
        //adding the calculated weightedgrade to textarea round to 3 decimal places
        weightedScore.setText("WeightedScore"+"\n"+Math.round(totalWeightGrade*1000D)/1000D);
    }

}
