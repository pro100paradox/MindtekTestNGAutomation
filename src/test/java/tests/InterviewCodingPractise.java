package tests;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class InterviewCodingPractise {

    public static void main(String[] args) {
        // Reverse given String value
        String str = "apple";
        // create variable to store reversed version of str
        StringBuilder reverse = new StringBuilder();

        // iterate over input string from the back with charAt
        for (int i = str.length() - 1; i >= 0; i--) {
            // add chars to reversed variable
            reverse.append(str.charAt(i));
        }
        System.out.println(reverse);
        int[] numArray = {8, 7, 6, 5, 4, 3, 2, 1};
        for (int i = 0; i < numArray.length / 2; i++) {
            //                  0(8)
            int temp = numArray[i];
            //       0(8)                       0(8)
            numArray[i] = numArray[numArray.length - i - 1];
            //                       0(8)
            numArray[numArray.length - i - 1] = temp;
        }
        System.out.println(Arrays.toString(numArray));

        int[] x = {5, 4, 3, 2, 1};
        for (int i = x.length - 1; i >= 0; i--) {
            System.out.print(x[i]);


        }
        String words = "apple banana kiwi";
        StringBuilder reverseWords = new StringBuilder();

        String[] arrayWords = words.split(" ");

        for (int i = arrayWords.length - 1; i >= 0; i--) {
            reverseWords.append(arrayWords[i] + " ");

        }
        System.out.println("\n" + reverseWords);

        String[] randomArray = {"John", "Patel", "Charly", "Sarah"};

        for(int i = 0; i<randomArray.length/2;i++){
            String temp = randomArray[i];
            randomArray[i]=randomArray[randomArray.length-i-1];
            randomArray[randomArray.length-i-1]=temp;
        }
        String newString = Arrays.toString(randomArray);
        System.out.println(newString.substring(1,newString.lastIndexOf("]")));
    }

    
}


