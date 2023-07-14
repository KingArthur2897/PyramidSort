import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] vector = new int[] {
                4,2,5,1,6,2,8,9,0,1
        };
        pyramidsort(vector);

        System.out.println(Arrays.toString(vector));
    }

    public static void heapify(int[] a, int heapSize, int rootIndex) {
        int largest = rootIndex;
        int leftChild = 2 * rootIndex + 1;
        int rightChild = 2 * rootIndex + 2;

        if (leftChild < heapSize && a[leftChild] > a[largest] )
            largest = leftChild;


        if (rightChild < heapSize && a[rightChild] > a[largest])
            largest = rightChild;


        if (largest != rootIndex) {
            int temp = a[rootIndex];
            a[rootIndex] = a[largest];
            a[largest] = temp;

            heapify(a, heapSize, largest);
        }
    }

    public static void pyramidsort(int[] a) {
        for (int i = a.length / 2 - 1; i >= 0;i--){
            heapify(a, a.length, i);
        }

        for (int i = a.length - 1; i >= 0;i--){
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;

            heapify(a, i, 0);
        }
    }


}

