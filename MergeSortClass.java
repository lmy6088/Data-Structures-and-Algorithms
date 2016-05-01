import java.util.Scanner;

/**
 * Created by lauminyi on 26/2/16.
 */
public class MergeSortClass {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number of elements u want to sort");
        int length = scan.nextInt();
        int[] numbers = new int[length];
        System.out.println("Numbers before sorting");
        for(int i=0; i<numbers.length; i++) {
            numbers[i] = (int) (Math.random() * 1000);
            System.out.print(numbers[i] + " ");
        }
        System.out.println("");
        numbers=MergeSort(numbers);
        System.out.println("Numbers after sorting");
        for(int i=0; i<numbers.length; i++){
            System.out.print(numbers[i] + " ");
        }

    }

    public static int[] MergeSort(int[] Array){
        if(Array.length==1){
            return Array;
        }
        else {
            int n = (int) Math.floor(Array.length / 2);
            int[] leftArray = new int[n];
            int[] rightArray = new int[Array.length - n];
            for (int i = 0; i < Array.length; i++) {
                //Here we push elements from 1 to n to the left array
                if (i < n) {
                    leftArray[i] = Array[i];
                } else {
                    rightArray[i - n] = Array[i];
                }
            }
            leftArray = MergeSort(leftArray);
            rightArray = MergeSort(rightArray);
            Array = Merge(leftArray, rightArray);
            return Array;
        }

    }

    public static int[] Merge(int[] left, int[] right){
        int[] MergedArray= new int[left.length+right.length];
        int leftcounter=0;
        int rightcounter=0;
        for(int i=0; i<left.length+right.length; i++){
            //Here we check if the leftcounter is equal to the length of left array.
            //If it is leftarray is empty hence mergedArray should take the elements from right array.
            if(leftcounter==left.length){
                MergedArray[i]=right[rightcounter];
                rightcounter++;
            }
            //vice versa for the right array
            else if(rightcounter==right.length){
                MergedArray[i]=left[leftcounter];
                leftcounter++;
            }
            //Now we compare the values of right and left arrays.
            //If the value of that array if bigger we add that element to the merged array.
            else if(left[leftcounter]<right[rightcounter]){
                MergedArray[i]=left[leftcounter];
                leftcounter++;
            }
            else{
                MergedArray[i] = right[rightcounter];
                rightcounter++;
            }

        }
        return MergedArray;
    }


}

