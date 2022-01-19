import java.util.ArrayList;

public class calculateProducts {

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<Integer> arrayResult = new ArrayList<>();

        arrayList.add(3);
        arrayList.add(2);
        arrayList.add(1);

        // looping through the array

        for(int i=0; i < arrayList.size(); i++) {
            int product = 1;

            for(int k=0; k <  arrayList.size(); k++) {
                if(k != i) {
                    product *= arrayList.get(k);
                }
            }

            arrayResult.add(product);
        }

        for (Integer integer: arrayResult) System.out.println(integer + ",");
    }


}
