package Assignment7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class FileGUI extends JFrame implements ActionListener {
    JLabel readingFileNameLabel=new JLabel("Reading File Name"); //input filename label
    JTextField  readingFileName=new JTextField("annual.csv"); //input filename
    JButton readButton=new JButton("Click to read from file"); // button for reading from input file
    JTextArea contentRead=new JTextArea(); // text area for displaying data read from input file
    JLabel writingFileNameLabel=new JLabel( "File Name to write"); //output filename label
    JTextField  writingFileName=new JTextField(20); //output filename

    JButton writeButton=new JButton("Click to write to file"); //button for writing new file

    JTextArea contentNewFile=new JTextArea(); // text area for displaying data read from input file

    FileReadWrite fileReadWrite=new FileReadWrite(); //object of FileReadWrite class

    ArrayList<String> input=new ArrayList<>(); //arrayList for input file data

    ArrayList<String> output=new ArrayList<>(); //arrayList for output file data

    public FileGUI(){ //constructor
        // setting application title and layout
        setTitle("File Read Write Application");
        setLayout(new FlowLayout());
        setVisible(true);
        setSize(1000,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // adding all elements to the frame
        add(readingFileNameLabel);
        add(readingFileName);
        readingFileNameLabel.setLabelFor(readingFileName);

        add(readButton);
        readButton.addActionListener(this);

        add(contentRead);

        add(writingFileNameLabel);
        add(writingFileName);
        writingFileNameLabel.setLabelFor(writingFileName);

        add(writeButton);
        writeButton.addActionListener(this);

        add(contentNewFile);

        System.out.println("Added all elements to the frame");
    }

    public void actionPerformed(ActionEvent ae) {
       if(ae.getSource()==readButton){
          // reads file on button click
            String readFileName=readingFileName.getText();
            fileReadWrite.readFile(readFileName);
            input=fileReadWrite.getInputData();
            //displays the first 5 lines of input file in textarea excluding heading
           for(int i=1;i<6;i++){
               contentRead.append(input.get(i));
                contentRead.append("\n");
            }
        }

       if(ae.getSource()==writeButton){
           //write the new file
           String writeFileName=writingFileName.getText();
           fileReadWrite.writeFile(writeFileName);
           output=fileReadWrite.getOutputData();
           //displays the first 5 lines of second file in textarea excluding heading
           for(int i=1;i<6;i++){
               contentNewFile.append(output.get(i));
           }
       }
    }
}
