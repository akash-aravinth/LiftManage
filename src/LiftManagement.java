import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LiftManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExecutorService service = Executors.newFixedThreadPool(5);
        Database database = new Database();
        database.addLifts();
        System.out.println("Welcome To Lift Management System");
        while (true){
            int choice = scanner.nextInt();
            switch (choice){
                case 1 : {
                    System.out.println("Enter Source");
                    int source = scanner.nextInt();
                    System.out.println("Enter Destination");
                    int destination = scanner.nextInt();
                    service.submit(new RequestThread(source,destination,database));
                    break;
                }
                case 2 : {
                    database.printLift();
                    break;
                }
                default:{
                    System.out.println("Enter Valid Choice 1 -> Get Lift 2 -> Print Lift");
                    break;
                }
            }
        }
    }
}
