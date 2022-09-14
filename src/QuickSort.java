import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public void quicksort(int[] A){
        quicksort(A, 0, A.length - 1);
    }

    private void quicksort(int[] A, int low, int high){

        if(low < high + 1){
            int c = changes(A, low, high);
            quicksort(A, low, c - 1);
            quicksort(A, c + 1, high);
        }
    }

    private void swap(int[] A, int index1, int index2){
        int temp = A[index1];
        A[index1] = A[index2];
        A[index2] = temp;
    }

    private int getPivot(int low, int high){
        Random random = new Random();
        return random.nextInt((high - low) + 1) + low;
    }

    private int changes(int[] A, int low, int high){
        swap(A, low, getPivot(low, high));
        int border = low + 1;
        for(int i = border; i <= high; i++){
            if(A[i] < A[low]){
                swap(A, i, border++);
            }
        }
        swap(A, low, border - 1);
        return border -1;
    }

    public static void main(String[] args){
        QuickSort sort = new QuickSort();
        int[] A = {90, 78, 65, 54, 43, 32, 25, 17, 8, 0};
        System.out.println(Arrays.toString(A));
        sort.quicksort(A);
        System.out.println(Arrays.toString(A));
    }
}
//Insertion Sort is the fastest
//Quick Sort also the best one to use
//Merge Sort Worst case
//Quick Sort is the average case