/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0051;

/**
 *
 * @author asus
 */
public class MenuComputer {
     public static void main(String[] args) {
        ComputerProgram cp = new ComputerProgram();
        CheckValidtion check = new CheckValidtion();
        int choice = 0 ;
        
         do {             
             cp.mennu();
             choice = check.checkInputChoice(1,3);
             switch(choice){
                 case 1:
                     cp.normalCalculator();
                     break;
                 case 2:
                     cp.BMICalculator();
             }
             
         } while (choice >0 && choice <3);
          
     }
}
