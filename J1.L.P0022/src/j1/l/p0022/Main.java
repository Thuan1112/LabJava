/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.l.p0022;

import java.util.ArrayList;
import validation.CheckValid;

/**
 *
 * @author asus
 */
public class Main {

    public static void main(String[] args) {
        
        CheckValid check = new CheckValid();
        Manager m = new Manager();
        int choice = 0;

        do {
            m.menu();
            choice = check.checkInputNumber(1, 5);
            switch (choice) {
                case 1:
                    m.createCandidate(0);
                    break;
                case 2:
                    m.createCandidate(1);
                    break;
                case 3:
                    m.createCandidate(2);
                    break;
                case 4:
                    m.showList();
                    m.searchCandidate();
                    break;
            }
        } while (choice > 0 && choice < 5);

    }

}
