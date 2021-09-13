
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
public class LetterAndCharacterCount {

    /**
     * @param args the command line arguments
     */
    // Create an array of size 256 i.e. ASCII_SIZE 
    static final int MAX_CHAR = 256;

    public static void countCharacter(String str) {
        int count[] = new int[MAX_CHAR];

        int len = str.length();

        for (int i = 0; i < len; i++) {
            count[str.charAt(i)]++;
        }
        char ch[] = new char[str.length()];
        for (int i = 0; i < len; i++) {
            ch[i] = str.charAt(i);
            int find = 0;
            for (int j = 0; j <= i; j++) {
                if (str.charAt(i) == ch[j]) {
                    find++;
                }
            }

            if (find == 1) {
                System.out.println(str.charAt(i) + " = " + count[str.charAt(i)]);
            }
        }
    }

    public static void countLetter() {
        int word = 0;
        Scanner wordcounter = new Scanner(System.in);
        while (wordcounter.hasNext()) {
            wordcounter.next();
            word++;
        }
        System.out.println("You hav entered " + word + " words.");
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter your content: ");
//        String str = sc.nextLine().trim();
//        countCharacter(str);
        System.out.println("Simple Java Word Count Program");

            String str1 = "Today is Holdiay Day";

            int wordCount = 1;

            for (int i = 0; i < str1.length(); i++) 
            {
                if (str1.charAt(i) == ' ') 
                {
                    wordCount++;
                } 
                System.out.println(str1.charAt(i)+ "= " + wordCount);
            }

            
    }

}
