package recursion;

import java.util.List;

public class EvenNumbers {

    public void printEvenNumbers(List<Integer> numbers) {
        printEvenNumbers(numbers, 0);
    }

    private void printEvenNumbers(List<Integer> numbers, int index) {
        if (index == numbers.size()) {
            return;
        }
        var number = numbers.get(index);
        if (number % 2 == 0) {
            System.out.println(number);
        }
        printEvenNumbers(numbers, index + 1);
    }

}
