import java.util.ArrayList;

/*
* Good morning! Here's your coding interview problem for today.

This problem was recently asked by Google.

Given a list of numbers and a number k, return whether any two numbers from the list add up to k.

For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.

Bonus: Can you do this in one pass?
* */
public class Day1 {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        arrayList.add(10);
        arrayList.add(15);
        arrayList.add(3);
        arrayList.add(7);
        arrayList.add(10);

        Integer k = 17;
        Integer sum = 17;

        for (int i = 0; i <arrayList.size(); i++) {
            int possibleNum = sum - arrayList.get(i);
            int possiblePositionOfNUm = arrayList.lastIndexOf(possibleNum);
            if( possiblePositionOfNUm >= 0 && possiblePositionOfNUm != i ) {
                System.out.println(arrayList.get(i) + " + " + arrayList.get(possiblePositionOfNUm) );
                break;
            }
        }
    }
}
