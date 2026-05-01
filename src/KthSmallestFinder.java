import java.util.*;

public class KthSmallestFinder {

    public static void sortNumbers(int[] numbers) {
        mergeSortNumbers(numbers, 0, numbers.length - 1);
    }

    public static void mergeSortNumbers(int[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSortNumbers(array, left, middle);
            mergeSortNumbers(array, middle + 1, right);
            mergeNumbers(array, left, middle, right);
        }
    }

    public static void mergeNumbers(int[] array, int left, int middle, int right) {
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

    public static int findKthSmallest(int[] numbers, int position) {
        sortNumbers(numbers);
        return numbers[position - 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int arraySize = scanner.nextInt();
        int[] numbers = new int[arraySize];

        for (int i = 0; i < arraySize; i++) {
            numbers[i] = scanner.nextInt();
        }

        int kthPosition = scanner.nextInt();

        System.out.println(findKthSmallest(numbers, kthPosition));
    }
}