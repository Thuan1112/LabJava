 /* * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0064;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author asus
 */
public class CheckDateFormat{

    /**
     * @param args the command line arguments
     */
    private static final Scanner sc = new Scanner(System.in);
    private static final String PHONE_REGEX = "^\\d{10}\\d*$";
    private static final String EMAIL_REGEX = "^[A-Za-z0-9.+-_%]+@[A-Za-z.-]+\\.[A-Za-z]{2,4}$";
    
    public static String checkPhoneNumber(){
        while (true) {
            String result = sc.nextLine().trim();
        
            if (result.matches(PHONE_REGEX)) {
                return result;
            } else {
                System.err.println("Phone is number with minimum 10 characters");
                System.out.print("Enter again: ");
            }
        }
    }
    
    public static String checkEmail(){

        while (true) {
            String result = sc.nextLine().trim();
            
            if (result.matches(EMAIL_REGEX)) {
                return result;
            } else {
                System.err.println("Email with format <account name>@<domain>");
                System.out.print("Enter again: ");
            }
        }
    }
    
    public static String checkDate(){
        while (true) {
            try {
                String dateCheck = sc.nextLine().trim();
                Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateCheck);
                return dateCheck;
            } catch (ParseException ex) {
                System.out.print("Date: ");
                System.err.println("Date to correct format(dd/MM/yyyy)");
            }
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("====Validation programe====");
        System.out.print("Phone number :");
        String phone = checkPhoneNumber();
        System.out.print("Email :");
        String email = checkEmail();
        System.out.print("Date (dd/MM/yyyy):");
        String date = checkDate();
    }
    
}
