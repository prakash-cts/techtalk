package com.cognizant.techtalk.sarmi;

import java.util.*;

/**
 * @author 868065
 */
public class SarmiMain {
    public static void main(String[] args) {
//        List<Integer> indexList1 = getIndexOfSwappedLetters("Helloh worldw",'H');
//        List<Integer> indexList2 = getIndexOfSwappedLetters("Helloh worldw",'W');
//        System.out.println(indexList1);
//        System.out.println(indexList2);
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the position ");
        int pos = in.nextInt();
        System.out.println("Enter the character ");
        String input = in.nextLine();
        String input2 = in.nextLine();
        char character1 = input2.charAt(0);
        char character2 = input2.charAt(2);
        System.out.println("Enter the string ");
        String input1 = in.nextLine();
        List<Integer> indexList1 = getIndexOfSwappedLetters(input1,character1);
        List<Integer> indexList2 = getIndexOfSwappedLetters(input1,character2);
//        System.out.println(indexList1);
//        System.out.println(indexList2);
//        System.out.println(character1);
//        System.out.println(pos);
//        System.out.println(input);
//        System.out.println(input2);
        input1 = replaceSubString(input1, character2,indexList1);
        input1 = replaceSubString(input1, character2,indexList2);
    }
    private static String replaceSubString(String str,char character, List<Integer>  posList){
//        String str = "Techie Delight";
//        char ch = '_';
//        int pos = 1;
        System.out.println(str);
        System.out.println(character);
        System.out.println(posList);
        for(int i:posList){
            int pos = i;
            StringBuilder sb = new StringBuilder(str);
            if(Character.isUpperCase(sb.charAt(pos))){
                sb.setCharAt(pos, character);
            }else if(Character.isLowerCase(sb.charAt(pos))){
                char c= Character.toLowerCase(sb.charAt(pos));
                sb.setCharAt(pos, c);
            }
            // replace character at the specified position

            str = sb.toString();

            // print the modified string
            System.out.println(str);

        }
        return str;

    }

    private static List<Integer> getIndexOfSwappedLetters(String str, char character) {
        if(!Character.isUpperCase(character)){
            System.out.println("Provide upper case only");
            System.exit(0);
        }
//        String characterString = String.valueOf(character);
        List<Integer> indexList = new ArrayList<>();
        List<Character> charList = new ArrayList<>();
        charList.add(character);
        charList.add(Character.toLowerCase(character));
        String s1=str;
        for(char character1:charList){
            int index = s1.indexOf(character1);
            while (index != -1) {
//                System.out.println(index);
                indexList.add(index);
                index = s1.indexOf(character1, index + 1);
            }
        }

        return indexList;
    }
}
