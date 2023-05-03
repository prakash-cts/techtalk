package com.cognizant.sarmi;

import java.util.Scanner;

/**
 * @author 868065
 */
public class SarmiNew {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Get the dimensions of the chocolate
//        System.out.print("Enter the number of rows of the chocolate: ");
        int n = input.nextInt();
//        System.out.print("Enter the number of columns of the chocolate: ");
        int m = input.nextInt();

        // Determine the winner
        boolean firstPlayerWins = false;
        if ((n * m) % 2 == 0) {
            firstPlayerWins = true;
        }

        // Output the result
        if (firstPlayerWins) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        /*String str1 = "hello";
        String str2 = "hi";

// Compare the two strings lexicographically
        int result = str1.compareTo(str2);
        System.out.println(str1.compareTo(str2));

// Output the result
        if (result < 0) {
            System.out.println(str1 + " comes before " + str2 + " lexicographically.");
        } else if (result > 0) {
            System.out.println(str2 + " comes before " + str1 + " lexicographically.");
        } else {
            System.out.println(str1 + " and " + str2 + " are lexicographically equal.");
        }*/

    }
}
class FindRemainingSoldiers {
    public static String defeatSoldiers(String soldiers, String pattern) {
        StringBuilder sb = new StringBuilder(soldiers);

        int i = 0;
        while (i <= sb.length() - pattern.length()) {
            boolean match = true;
            for (int j = 0; j < pattern.length(); j++) {
                if (sb.charAt(i + j) != pattern.charAt(j)) {
                    match = false;
                    break;
                }
            }

            if (match) {
                sb.delete(i, i + pattern.length());
            } else {
                i++;
            }
        }

        if (sb.length() > 0) {
            return sb.toString();
        } else {
            return "Defeat";
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String soldiers = input.nextLine();//"×AbcyAAbcbAbccz";
        String pattern = input.nextLine();//"Abc";
//        String remaining = defeatSoldiers(soldiers, pattern);
        while(soldiers.contains(pattern)){
            soldiers = defeatSoldiers(soldiers, pattern);
        }

        System.out.println(soldiers);
    }
}

