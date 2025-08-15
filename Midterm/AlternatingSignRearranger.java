import java.util.LinkedList;

public class AlternatingSignRearranger {
    int[] arr;

    public AlternatingSignRearranger(int[] a) {
        arr = a;
    }

    public void rearrangeAlternating() {
        LinkedList<Integer> posList = new LinkedList<>();
        LinkedList<Integer> negList = new LinkedList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                negList.addLast(arr[i]); //reverses order of neg values
            } else {
                posList.addFirst(arr[i]); //maintains order of pos values
            }
        }

        int index = 0;
        int[] rearrangedArr = new int[arr.length]; //returned array with rearranged elements
        
        while (!posList.isEmpty() && !negList.isEmpty()) { //while both lists still have elements
            rearrangedArr[index++] = posList.removeFirst();
            rearrangedArr[index++] = negList.removeFirst();
        }

        if (!posList.isEmpty()) {
            while(!posList.isEmpty()) { //adds any additional elements that may still exist
                rearrangedArr[index++] = posList.removeFirst();
            }
        }
        else if (!negList.isEmpty()) {
            while(!negList.isEmpty()) {
                rearrangedArr[index++] = negList.removeFirst();
            }
        }

        arr = rearrangedArr;
        
    }

    public void printArray() {
        
        LinkedList<Integer> posList = new LinkedList<>();
        LinkedList<Integer> negList = new LinkedList<>();
        LinkedList<Integer> rearrangedList = new LinkedList<>();
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                negList.addFirst(arr[i]); //reverses order of neg values
            } else {
                posList.addFirst(arr[i]); //maintains order of pos values
            }
        }
        
        while (!posList.isEmpty() && !negList.isEmpty()) { //while both lists still have elements
            rearrangedList.addLast(posList.removeFirst());
            rearrangedList.addLast(negList.removeFirst());
        }        

        if (posList.size() != 0) {
            while(posList.size() != 0) { //adds any additional elements that may still exist
                rearrangedList.add(posList.removeFirst());
            }
        }
        
        else if (negList.size() != 0) {
            while(negList.size() != 0) {
                rearrangedList.addLast(negList.removeFirst());

            }
        }
        
        System.out.print(rearrangedList);

    }
}
