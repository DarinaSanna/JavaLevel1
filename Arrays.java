import java.util.Random;

public class Arrays {
    public static void main (String[] args) {
        int[] numbers = new int[5];
        int numbersCount = numbers.length;
        Random random = new Random();

        for (int i = 0; i < numbersCount-1; i++) {
            numbers [i] = random.nextInt(100);
        }

        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < numbersCount-1; i++) {
                if (numbers[i] > numbers[i+1]){
                    int x = numbers[i];
                    numbers[i] = numbers[i+1];
                    numbers[i+1] = x;
                    sorted = false;
                }

            }
        }
        for (int i = 0; i < numbersCount; i++) {
            System.out.println(numbers[i]);
        }
    }

}
