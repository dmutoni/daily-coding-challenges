/* Good morning! Here's your coding interview problem for today.

This problem was asked by Uber.

Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.

For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].

Follow-up: what if you can't use division? */

import java.util.ArrayList;

public class Day2 {

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<Integer> arrayResult = new ArrayList<>();

        arrayList.add(3);
        arrayList.add(2);
        arrayList.add(1);

        int prod = 1;
        // looping through the array

        for(Integer integer: arrayList) prod*= integer;

        for (Integer value : arrayList) arrayResult.add(prod / value);

        for (Integer integer: arrayResult) System.out.println(integer + ",");
    }


}
