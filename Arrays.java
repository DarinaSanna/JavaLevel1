import java.util.Random;

public class Arrays {
    public static void main (String[] args) {
        int[] numbers = new int[5];
        int numbersCount = numbers.length;
        Random random = new Random();

        fillArray(numbers, numbersCount, random);

        sort(numbers, numbersCount);

        printArray(numbers, numbersCount);

    }

    private static void fillArray(int[] numbers, int numbersCount, Random random) {
        for (int i = 0; i < numbersCount; i++) {
            numbers [i] = random.nextInt(100);
        }
    }

    private static void sort(int[] numbers, int numbersCount) {
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < numbersCount - 1; i++) {
                if (numbers[i] > numbers[i + 1]) {
                    int x = numbers[i];
                    numbers[i] = numbers[i + 1];
                    numbers[i + 1] = x;
                    sorted = false;
                    numbersCount = numbersCount-1;
                }
            }
        }
    }

    private static void printArray(int[] numbers, int numbersCount) {
        for (int i = 0; i < numbersCount; i++) {
            System.out.println(numbers[i]);
        }
    }
}
