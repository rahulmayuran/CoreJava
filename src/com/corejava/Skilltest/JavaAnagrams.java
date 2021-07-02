package com.corejava.Skilltest;

import java.util.Scanner;

/* A Hacker Rank skill test to find whether the given two strings are anagrams are not?

Input : Cat, Tea                Output : Not Anagrams
Input : Cat, act                Output : Anagrams
* */
public class JavaAnagrams
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the first String -> ");
        String str1 = input.next();
        System.out.println("Enter the second String -> ");
        String str2 = input.next();

        input.close();
        boolean result = isAnagram(str1,str2);
        System.out.println((result)?"ANAGRAMS":"NOT ANAGRAMS");
    }

    private static boolean isAnagram(String one, String two)
    {
        char[] charArrayOfOne = one.toLowerCase().toCharArray();
        char[] charArrayOfTwo = two.toLowerCase().toCharArray();

        if(charArrayOfTwo.length != charArrayOfTwo.length)
            return false;

        int [] counter = new int[26];

        for (int i = 0; i < charArrayOfOne.length; i++)
        {
            counter[charArrayOfOne[i]-97]++;
            counter[charArrayOfTwo[i]-97]--;
        }

        for (int i = 0; i < 26; i++)
        {
            if(counter[i]!=0)
                return false;
        }
        return true;
    }
}
