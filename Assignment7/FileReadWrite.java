package Assignment7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReadWrite {
    ArrayList<String> inputData=new ArrayList<>();
    ArrayList<String> outputData=new ArrayList<>();
    public void readFile(String filename){

        try{
            // filePath is written based on windows OS
            String localDir = System.getProperty("user.dir");
            String localDirJavaPath=localDir.replace("\\", "\\\\");
            File myObj = new File(localDirJavaPath+"\\\\"+filename);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                inputData.add(data);
                //extracting first 3 fields and storing it to a data structure
                int fieldIndex=data.indexOf(',', 1 + data.indexOf(',', 1 + data.indexOf(',')));
                outputData.add(data.substring(0,fieldIndex)+"\n");
            }
            myReader.close();
        }
        catch (FileNotFoundException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void writeFile(String filename){

        try {
            FileWriter myWriter = new FileWriter(filename);
            for(int i=0;i<outputData.size();i++){
                myWriter.write(outputData.get(i));
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public ArrayList<String> getInputData() { //getter for inputData
        return inputData;
    }

    public ArrayList<String> getOutputData() { //getter for outputData
        return outputData;
    }

}
