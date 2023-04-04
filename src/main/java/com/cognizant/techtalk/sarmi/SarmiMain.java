package com.cognizant.techtalk.sarmi;

import java.util.*;

/**
 * @author 868065
 */
public class SarmiMain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Number of swaps ");
        int pos2 = in.nextInt();
        System.out.println("Enter the character ");
        String input = in.nextLine();
        String input2 = in.nextLine();
        char character1 = input2.charAt(0);
        char character2 = input2.charAt(2);
        System.out.println("Enter the string ");
        String input1 = in.nextLine();
        List<Integer> indexList1 = getIndexOfSwappedLetters(input1,character1);
        List<Integer> indexList2 = getIndexOfSwappedLetters(input1,character2);

        input1 = replaceSubString(input1, character2,indexList1,pos2);
        input1 = replaceSubString(input1, character1,indexList2,pos2);
        System.out.println(input1);
    }
    private static String replaceSubString(String str,char character, List<Integer>  posList, int pos2){
        System.out.println(posList);
        Collections.sort(posList);
        System.out.println(posList);
        int count = 0;
        for(int i:posList){
            int pos = i;
            StringBuilder sb = new StringBuilder(str);
            if(Character.isUpperCase(sb.charAt(pos))){
                sb.setCharAt(pos, character);
            }else if(Character.isLowerCase(sb.charAt(pos))){
                char c= Character.toLowerCase(character);
                sb.setCharAt(pos, c);
            }

            str = sb.toString();

            count ++;
            if(count==pos2){
                break;
            }
        }
        return str;
    }

    private static List<Integer> getIndexOfSwappedLetters(String str, char character) {
        if(!Character.isUpperCase(character)){
            System.out.println("Provide upper case only");
            System.exit(0);
        }
        List<Integer> indexList = new ArrayList<>();
        List<Character> charList = new ArrayList<>();
        charList.add(character);
        charList.add(Character.toLowerCase(character));
        String s1=str;
        for(char character1:charList){
            int index = s1.indexOf(character1);
            while (index != -1) {
                indexList.add(index);
                index = s1.indexOf(character1, index + 1);
            }
        }
        return indexList;
    }
}
