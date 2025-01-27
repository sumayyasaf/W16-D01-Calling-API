package com.omar;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        apacheLangMethods();

    }

    public static void apacheLangMethods() {
        String student1 = "Sumayya";
        String student2 = "Paul";


        System.out.println(StringUtils.equals(student1, student2));

//        isEmpty()
        System.out.println(StringUtils.isEmpty(student1));
        System.out.println(StringUtils.isBlank(student1));

//        trim()
        System.out.println(StringUtils.trim(student2));

//        endsWith()
        System.out.println(StringUtils.endsWith(student2, "auz"));
        System.out.println(StringUtils.startsWith(student2, "Pa"));


//        indexOf(), lastIndexOf()

        System.out.println(StringUtils.indexOf(student1, "y"));
        System.out.println(StringUtils.lastIndexOf(student1, "y"));

        System.out.println(StringUtils.indexOfAny(student1, "s", "z", "z"));


//        contains()

        System.out.println(StringUtils.contains(student1, "Sum"));
        System.out.println(StringUtils.containsAny(student1, "zzz", "Suma"));
        System.out.println(StringUtils.containsNone(student1, "www"));


//        substring: left, right, middle
        System.out.println(StringUtils.left(student1, 4));
        System.out.println(StringUtils.right(student1, 4));
        System.out.println(StringUtils.mid(student1, 1, 3));

        String url = "www.google.com";

//        before, after, between
        System.out.println(StringUtils.substringAfter(url, "www."));
        System.out.println(StringUtils.substringBefore(url, ".com"));
        System.out.println(StringUtils.substringBetween(url, ".", "."));


//        remove()
        System.out.println(StringUtils.remove(url, "google"));

//        replace():
        System.out.println(StringUtils.replace(url, ".com", ".org"));


        String scentence = " Good Morning   Java  Class 1";
        System.out.println(StringUtils.normalizeSpace(scentence));

        System.out.println(StringUtils.isAlphaSpace(scentence));

        String password = "123445 6";

        System.out.println(StringUtils.isAlphanumeric(password));

        System.out.println(StringUtils.isNumericSpace(password));

        System.out.println(StringUtils.stripAccents("Cafè"));


        int[] myNums = {1, 2, 3, 4};
        System.out.println(ArrayUtils.contains(myNums, 5));


        System.out.println(NumberUtils.isDigits("123"));


        System.out.println(StringUtils.reverse(scentence));

        /*
        Check if the following strings are blank:
        "Hello"
        " "
        null
        Reverse the string "ApacheLang".
        Abbreviate the string "Apache Commons Lang3 is amazing!" to 15 characters.
        Exercise 2:
        Create an array of integers {1, 2, 3, 4, 5}.
        Check if the array contains the number 4.
        Reverse the array and print the result.

        */

        System.out.println(StringUtils.isBlank("Hello"));
        System.out.println(StringUtils.isBlank(" "));
        System.out.println(StringUtils.isBlank(null));

        System.out.println(StringUtils.reverse("ApacheLang"));
        System.out.println(StringUtils.abbreviate("Apache Commons Lang3 is amazing!",15));


        int[] exerciseArray = {1,2,3,4,5};
        System.out.println(ArrayUtils.contains(exerciseArray,4));
        ArrayUtils.reverse(exerciseArray);
        System.out.println(Arrays.toString(exerciseArray));

        String myString = "Maryam";

        reverseStringInplace(myString);
        System.out.println("Old String: " + myString);




    }

    public static void reverseStringInplace(String input){
        String newI = StringUtils.reverse(input);
        input = newI;
    }

    public static String reverseStringReturnNewString(String input){
            return StringUtils.reverse(input);
    }
}