package j1.s.p0001;

import java.util.Random;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author asus
 */
public class BubbleSortAlgorithm {

    /**
     * @param args the command line arguments
     */
    static Scanner sc = new Scanner(System.in);

    public static int checkInputNumber() {
        int num = 0;
        boolean valid;
        do {
            valid = true;
            try {
                num = Integer.parseInt(sc.nextLine().trim());
                if (num <= 0) {
                    System.out.println("Invalid input!");
                    System.out.print("Input again: ");
                    valid = false;
                }
            } catch (NumberFormatException e) {
                System.err.println("Please input number");
                System.out.print("Enter again: ");
                valid = false;
            }
        } while (!valid);
        return num;
    }

    public static void bubbleSort(int arr[], int n) {
       boolean haveSwap = true;
        while (haveSwap) {            
            haveSwap = false;
            for (int i = 0; i < n-1; i++) {
                if(arr[i] > arr[i+1]){
                    int swap = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = swap;
                    haveSwap = true;
                }
            }
        }

        System.out.println("Sorted array :");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Random rd = new Random();
        System.out.println("");
        System.out.println("Enter number of array: ");
        int n = checkInputNumber();

        int[] arr = new int[n];

        System.out.println("Unsorted array:");
        for (int i = 0; i < n; i++) {
            arr[i] = rd.nextInt(n);
            System.out.print(arr[i] + " ");
        }

        System.out.println("");
        bubbleSort(arr, n);

    }

}
