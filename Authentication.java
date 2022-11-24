import java.io.IOException;
import java.util.Scanner;

public class Authentication {
    ActionWithTimetable myTimetable = new ActionWithTimetable("Timetable.txt");
    EditTimeTable editTimeTable = new EditTimeTable();
    Scanner scan = new Scanner(System.in);
    public void login() throws IOException {
        int user ;
        System.out.println("Press 1 if you're a admin user\nPress 2 if you're a student user");
        user = scan.nextInt();
        if (user == 1){
            adminAuthentication();
        }
        else if(user == 2) {
            studentAuthentication();
        }
    }

    public void adminAuthentication() throws IOException {

        String adminUserName, adminPassword;

        System.out.print("Zoho School Admin User email:");//user mail:admin user
        scan.nextLine();
        adminUserName = scan.nextLine();
        System.out.print("Enter password:");//password: admin user
        adminPassword = scan.nextLine();
        if (adminUserName.equals("zohoschooladmin@2022") && adminPassword.equals("Zoho#2022")) {
            System.out.println("------Authentication Successful-----");

            System.out.println("Press 1 to edit Timetable");
            System.out.println("Press 2 to view Timetable");
            int userActionInput= scan.nextInt();
            if(userActionInput==1){
                myTimetable.showTimetable(myTimetable.tableIn2DAraay());
                editTimeTable.reWriteFile();
                myTimetable.showTimetable(myTimetable.tableIn2DAraay());

            } else if (userActionInput==2) {
                myTimetable.showTimetable(myTimetable.tableIn2DAraay());
            }
            else{
                System.err.print("Enter correct value");
                adminAuthentication();
            }
        } else {
            System.err.println("------Authentication Failed, Enter a valid mail and password");
        }
    }

    public void studentAuthentication(){
        String studentUserName , studentPassword;
        System.out.print("Enter Zoho School Student mail:");//user name: student user
        scan.nextLine();
        studentUserName = scan.nextLine();
        System.out.print("Enter Zoho School Student Password ");//password: student user
        studentPassword = scan.nextLine();
        if (studentUserName.equals("zohoschoolstudent@2022") && studentPassword.equals("Zoho*2022")){
            System.err.println("-----Authentication successful---");
            System.out.println();
            myTimetable.showTimetable(myTimetable.tableIn2DAraay());
        }
        else {
            System.err.println("------Authentication Failed, Enter a valid mail and password-----");
        }
    }
}
