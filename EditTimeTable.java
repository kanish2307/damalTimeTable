import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class EditTimeTable {
    int editedDay;
    int editedTime;
    int editedSession;
    int editRow;
    int editColumn;
    String editChar;
    Scanner scan = new Scanner(System.in);
    ActionWithTimetable actionWithTimetable =new ActionWithTimetable("Timetable.txt");


    public int day(){
        System.out.println("Choose a day from timetable to edit: \n" +
                "Press 1 for Monday \n" +
                "Press 2 for Tuesday \n" +
                "Press 3 for Wednesday \n" +
                "Press 4 for Thursday \n" +
                "Press 5 for Friday "
        );
        editedDay = scan.nextInt();
        if(editedDay > 5 ){

            System.err.println("Enter the correct value");
            return day();
        }

        return editedDay;

    }
    public int time(){
        System.out.println("Choose a time from timetable to edit: \n" +
                "Press 1 for 10 AM \n" +
                "Press 2 for 11 AM \n" +
                "Press 3 for 12 PM \n" +
                "Press 5 for 2 PM \n" +
                "Press 6 for 3 PM \n" +
                "Press 7 for 4 PM "
        );
        editedTime = scan.nextInt();
        if (editedTime > 7 || editedTime == 4 ){
            System.err.println("Enter the correct value");
            time();
        }
        return editedTime;
    }

    public String session(){
        System.out.println("Choose a session from timetable to edit: \n" +
                "Press 1 for Java \n" +
                "Press 2 for Maths \n" +
                "Press 3 for DSA \n" +
                "Press 4 for Creator\n" +
                "Press 5 for Web development \n" +
                "Press 6 for Raj san tech class \n"+
                "Press 7 for Java lab \n"+
                "Press 8 for Maths assignment \n"+
                "Press 9 for DSA lab \n"+
                "Press 10 for Creator lab \n"+
                "Press 11 for Web Development lab \n"+
                "Press 12 for English class "
        );
        editedSession = scan.nextInt();
        switch (editedSession){
            case 1:
                return "Java";
            case 2:
                return "Maths";
            case 3:
                return "DSA";
            case 4:
                return "Creator";
            case 5:
                return "Web Development";
            case 6:
                return "Raj san ";
            case 7:
                return "Java lab";
            case 8:
                return "Maths assignment";
            case 9:
                return "DSA lab";
            case 10:
                return "Creator lab";
            case 11:
                return "Web Development lab";
            case 12:
                return "English class";
            default:
                System.out.println("Enter correct value");
        }
        if (editedSession > 12){
            System.err.println("Enter the correct value");
            session();
        }

        return session();
    }
    private String addSpace(){
        String s =session();

        int a = 15-s.length();
        for(int i=0;i<a;i++){
            s=s+" " ;
        }
        return s;
    }
    public  String[][]  editTimetable(){
        editRow = day();
        editColumn= time();
        editChar=addSpace();
        String[][] tempAraay =actionWithTimetable.tableIn2DAraay();
        tempAraay[editRow][editColumn]=editChar;
        return tempAraay;

    }
    public void reWriteFile() throws IOException {
        String[][] tempArray=editTimetable();
        try
        {
            PrintWriter pr = new PrintWriter("Timetable.txt");

            for (int i=0; i<tempArray.length ; i++)
            {
                for(int j=0;j<tempArray[i].length;j++){
                    if(j==tempArray[i].length-1){
                        pr.print(tempArray[i][j]+"\n");
                    }
                    else{
                        pr.print(tempArray[i][j]+",");
                    }
                }
            }
            pr.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("file not  exists.");
        }

    }
}
