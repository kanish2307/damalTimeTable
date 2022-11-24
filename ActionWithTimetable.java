import java.io.*;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;

public class ActionWithTimetable {
    String fileLocation;
    int rows = 6;
    int columns = 8;
    String [][] myArray = new String[rows][columns];
    public ActionWithTimetable(String fileLocation){
        this.fileLocation =fileLocation;
        creatFile();

    }


    public void creatFile(){ //createFile() method create timetable file
        try {
            File file = new File(fileLocation);
            file.createNewFile();
        }
        catch (Exception e){
            System.out.print("error");
        }
    }
    public String[][] tableIn2DAraay(){

        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader(fileLocation)));
            while(sc.hasNextLine()) {
                for (int i=0; i<myArray.length; i++) {
                    String[] line = sc.nextLine().trim().split(",");
                    for (int j=0; j<line.length; j++) {
                        myArray[i][j] = line[j];
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return myArray;
    }
    public void  showTimetable(String[][] tempArray){
        for(int i=0;i< tempArray.length;i++){
            for(int j=0;j<tempArray[i].length;j++){
                System.out.print(tempArray[i][j]+" ");
            }
            System.out.println();
        }
    }



}
