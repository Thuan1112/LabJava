package j1.s.p0003;

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
public class InsertionSortAlgorithm {

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

    public static void insertionSort(int arr[], int n) {
        System.out.println("Sorted array:");
        for (int j = 1; j < n; j++) {
            int key = arr[j];
            int i = j - 1;
            while ((i > -1) && (arr[i] > key)) {
                arr[i + 1] = arr[i];
                i--;
            }
            arr[i + 1] = key;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");

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
        insertionSort(arr, n);

    }
}
