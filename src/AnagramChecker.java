import java.util.*;

public class AnagramChecker {

    public static void sortCharacters(char[] characters) {
        mergeSortCharacters(characters, 0, characters.length - 1);
    }

    public static void mergeSortCharacters(char[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSortCharacters(array, left, middle);
            mergeSortCharacters(array, middle + 1, right);
            mergeCharacters(array, left, middle, right);
        }
    }

    public static void mergeCharacters(char[] array, int left, int middle, int right) {
        char[] temp = new char[right - left + 1];
        int i = left, j = middle + 1, k = 0;

        while (i <= middle && j <= right) {
            if (array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }

        while (i <= middle) temp[k++] = array[i++];
        while (j <= right) temp[k++] = array[j++];

        for (int t = 0; t < temp.length; t++) {
            array[left + t] = temp[t];
        }
    }

    public static boolean checkIfAnagrams(String firstText, String secondText) {
        if (firstText.length() != secondText.length()) return false;

        char[] firstArray = firstText.toCharArray();
        char[] secondArray = secondText.toCharArray();

        sortCharacters(firstArray);
        sortCharacters(secondArray);

        for (int i = 0; i < firstArray.length; i++) {
            if (firstArray[i] != secondArray[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstInput = scanner.nextLine();
        String secondInput = scanner.nextLine();

        if (checkIfAnagrams(firstInput, secondInput)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}