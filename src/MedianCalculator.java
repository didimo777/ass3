import java.util.*;

public class MedianCalculator {

    public static void sortValues(int[] values) {
        mergeSort(values, 0, values.length - 1);
    }

    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);
            merge(array, left, middle, right);
        }
    }

    public static void merge(int[] array, int left, int middle, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = middle + 1, k = 0;

        while (i <= middle && j <= right) {
            if (array[i] <= array[j]) temp[k++] = array[i++];
            else temp[k++] = array[j++];
        }

        while (i <= middle) temp[k++] = array[i++];
        while (j <= right) temp[k++] = array[j++];

        for (int t = 0; t < temp.length; t++) {
            array[left + t] = temp[t];
        }
    }

    public static double calculateMedian(int[] values) {
        sortValues(values);

        int size = values.length;

        if (size % 2 == 1) {
            return values[size / 2];
        } else {
            return (values[size / 2 - 1] + values[size / 2]) / 2.0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberCount = scanner.nextInt();
        int[] values = new int[numberCount];

        for (int i = 0; i < numberCount; i++) {
            values[i] = scanner.nextInt();
        }

        System.out.println(calculateMedian(values));
    }
}