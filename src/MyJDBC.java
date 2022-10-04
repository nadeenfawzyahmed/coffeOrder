import java.sql.*;
import java.util.Scanner;

public class MyJDBC {
    public static void main(String[] args) throws Exception {
        Driver driver=new Driver();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name:");
        String userName = sc.nextLine();
        System.out.println("Enter 1 for Latte " + "\n" +
                "Enter 2 for cappuccino " + "\n" +
                "Enter 3 for Espresso " + "\n" +
                "Enter 4 for Americano " + "\n" +
                "Enter 5 for Flat white " + "\n");
        int id;
        Scanner s = new Scanner(System.in);
        id= s.nextInt();
        String coffeName=driver.retrievecoffeName(id);
        driver.addorder(userName, coffeName);
    }


}
